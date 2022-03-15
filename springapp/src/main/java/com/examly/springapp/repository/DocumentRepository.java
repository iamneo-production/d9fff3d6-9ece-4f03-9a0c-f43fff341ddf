package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document,Integer> {

}