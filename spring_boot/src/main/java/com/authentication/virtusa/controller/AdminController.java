package com.authentication.virtusa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.virtusa.model.LoanModel;
import com.authentication.virtusa.service.AdminService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	@Autowired
	AdminService calladminser;
	
	@GetMapping("/displaycustomers")
	public List<LoanModel> allcus()
	{
		return calladminser.getAll();
	}
	@DeleteMapping("/displaycustomers/{id}")
	public String deleteCustomer(@PathVariable("id") int id)
	{
		return calladminser.deleteCustomer(id);
	}
	@GetMapping("/displaycustomers/{id}")
	public Optional<LoanModel> getCustomer(@PathVariable("id") int id)
	{
		return calladminser.getCustomer(id);
	}
	@PutMapping("editCus/{id}")
	public LoanModel changeStatus(@PathVariable("id") int id,@RequestBody LoanModel t)
	{
		return calladminser.editCustomer(t,id);
	}
	@GetMapping("approve/{id}")
	public boolean approve(@PathVariable("id") int id)
	{
		return calladminser.approve(id);
	}
	@GetMapping("reject/{id}")
	public boolean reject(@PathVariable("id") int id)
	{
		return calladminser.reject(id);
	}
}
