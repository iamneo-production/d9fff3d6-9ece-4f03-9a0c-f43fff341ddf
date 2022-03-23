package com.examly.springapp.service;

import com.examly.springapp.model.LoanModel;
import com.examly.springapp.repository.DocumentRepository;
import com.examly.springapp.repository.LoanRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    @Autowired
    LoanRepository loanRepo;
    

    public LoanService(LoanRepository loanRepo, DocumentRepository docRepo) {
        super();
        this.loanRepo = loanRepo;
    }

    public LoanModel saveLoan(LoanModel loan) {
        return loanRepo.save(loan);
    }
  
}
