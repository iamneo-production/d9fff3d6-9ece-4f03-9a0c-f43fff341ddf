package com.examly.springapp.service;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.examly.springapp.model.Document;
import com.examly.springapp.repository.DocumentRepository;



@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document saveFile(MultipartFile file) throws IOException{
    	String documentName=file.getOriginalFilename();
    		Document document=new Document(documentName,file.getContentType(),file.getBytes());
    		return documentRepository.save(document);
    }
    public Optional<Document> getFile(Integer fileId) {
    	return documentRepository.findById(fileId);
    }
    public List<Document> getFiles(){
    	return documentRepository.findAll();
    }
}