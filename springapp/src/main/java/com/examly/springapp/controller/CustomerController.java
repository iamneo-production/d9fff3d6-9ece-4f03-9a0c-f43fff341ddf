package com.examly.springapp.controller;

import java.util.Optional;

import com.examly.springapp.model.LoanModel;
import com.examly.springapp.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "https://8081-addaafdafcfdfcbaaeddadfaadaeaacdfed.examlyiopb.examly.io")
public class CustomerController {
	@Autowired
	CustomerService callser;
	
	@GetMapping("/getProfile/{id}")
	public LoanModel getCustomer(@PathVariable("id") String id)
	{
		return callser.getCustomer(id);
	}
	@GetMapping("/displaycustomer/{id}")
	public Optional<LoanModel> getCustomer(@PathVariable("id") int id)
	{
		return callser.getCustomer(id);
	}
}
