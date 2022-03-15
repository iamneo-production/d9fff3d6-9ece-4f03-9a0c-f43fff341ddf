package com.examly.springapp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.examly.springapp.model.Document;
import com.examly.springapp.service.DocumentService;

@RestController
// @CrossOrigin(origins="http://localhost:4200")
@CrossOrigin("*")
public class DocumentController {
  
	@Autowired
	private DocumentService documentService;
	
	@GetMapping("/")
	public String get(Model model) {
		List<Document> document=documentService.getFiles(); 
		model.addAttribute("document", document);
		return "document";
	}
	
	@PostMapping("/uploadFile")
	// @CrossOrigin(origins="http://localhost:4200")
	@CrossOrigin("*")
	public Document uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
		return documentService.saveFile(file);
	}
	
	@PostMapping("/uploadFiles")
	// @CrossOrigin(origins="http://localhost:4200")
	@CrossOrigin("*")
	public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) throws IOException {
		for(MultipartFile file:files) {
			documentService.saveFile(file);
		}
		System.out.print("file Uploaded Sucessfully");
		return "/redirect";
	}
	
	@GetMapping("/downloadFile/{fileId}")
	// @CrossOrigin(origins="http://localhost:4200")
	@CrossOrigin("*")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId){
		Document document=documentService.getFile(fileId).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(document.getDocumentType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+document.getDocumentName()+"\"")
				.body(new ByteArrayResource(document.getData()));
		
	}
	
	
	
}

