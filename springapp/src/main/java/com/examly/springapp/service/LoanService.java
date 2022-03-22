package com.examly.springapp.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.ui.Model;

import java.util.Optional;
import java.io.ByteArrayOutputStream;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.examly.springapp.model.DocumentModel;
import com.examly.springapp.model.LoanApplicantModel;
import com.examly.springapp.repository.DocumentRepository;
import com.examly.springapp.repository.LoanApplicantRepository;

@Service
public class LoanService {
    @Autowired
    LoanApplicantRepository loanRepo;
    

    public LoanService(LoanApplicantRepository loanRepo, DocumentRepository docRepo) {
        super();
        this.loanRepo = loanRepo;
    }

    public LoanApplicantModel saveLoan(LoanApplicantModel loan) {
        return loanRepo.save(loan);
    }
  
}
