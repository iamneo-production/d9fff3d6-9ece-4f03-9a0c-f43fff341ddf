package com.examly.springapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.DocumentModel;
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
	
	@PostMapping("/uploadDocument")
	public boolean saveLoan(@RequestBody LoanApplicantModel loan)
	{
		return loanService.saveLoan(loan);
	}
	@PostMapping("/applyLoan")
	public boolean saveDocument(@RequestBody DocumentModel doc)
	{
		return loanService.saveDocument(doc);
	}
}
