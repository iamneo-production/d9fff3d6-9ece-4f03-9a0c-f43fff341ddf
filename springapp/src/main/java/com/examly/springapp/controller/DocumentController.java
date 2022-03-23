package com.examly.springapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.examly.springapp.model.DocumentModel;
import com.examly.springapp.repository.DocumentRepository;
import com.examly.springapp.repository.FileUploadResponse;

@RestController
@CrossOrigin(origins = "*")
public class DocumentController {
    @Autowired
	private DocumentRepository docRepo;

	public DocumentController(DocumentRepository docRepo) {
		super();
		this.docRepo = docRepo;
	}
    

	@PostMapping("/uploadDocument")
    @CrossOrigin(origins = "*")
	public FileUploadResponse saveDocument(@RequestParam("file") MultipartFile file,
        @RequestParam("documentType") String documentType) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		DocumentModel doc = new DocumentModel(fileName,documentType,file.getBytes());

		docRepo.save(doc);
		
		String url = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/getDocument/")
				.path(fileName)
				.toUriString();
        
        String contentType = file.getContentType();
		FileUploadResponse response = new FileUploadResponse(fileName,contentType,url);
		
		return response;
	}
	
	@GetMapping("/getDocument/{fileName}")
	ResponseEntity<byte[]> downloadFile(@PathVariable String fileName,HttpServletRequest request){
		
		DocumentModel doc = docRepo.findByDocumentName(fileName);
		
		String mimeType = request.getServletContext().getMimeType(doc.getDocumentName());
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(mimeType))
				.header(HttpHeaders.CONTENT_DISPOSITION,"inline; fileName=\"" +doc.getDocumentName() + "\"")
				.body(doc.getDocumentUpload());
		
	}
}
