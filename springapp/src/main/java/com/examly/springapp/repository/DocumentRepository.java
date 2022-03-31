package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.DocumentModel;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentModel, Long>{
   
    DocumentModel findByDocumentId(Long id);
    DocumentModel findByDocumentName(String fileName);
}
