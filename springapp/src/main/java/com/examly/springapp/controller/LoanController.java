package com.examly.springapp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.examly.springapp.model.LoanApplicantModel;
import com.examly.springapp.service.LoanService;

@RestController
@CrossOrigin(origins = "*")
public class LoanController {
	@Autowired
	LoanService loanService;

	public LoanController(LoanService loanService) {
		super();
		this.loanService = loanService;
	}

	@PostMapping("/applyLoan")
	@CrossOrigin(origins = "*")
	public Long uploadLoan(@RequestBody LoanApplicantModel loan) {
		loanService.saveLoan(loan);
		return loan.getLoanId();
	}
   

	
}
