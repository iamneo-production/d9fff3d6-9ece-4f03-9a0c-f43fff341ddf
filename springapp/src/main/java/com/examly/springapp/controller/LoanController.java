package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.examly.springapp.model.LoanModel;
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
	public Long uploadLoan(@RequestBody LoanModel loan) {
		loanService.saveLoan(loan);
		return loan.getLoanId();
	}
   
}
