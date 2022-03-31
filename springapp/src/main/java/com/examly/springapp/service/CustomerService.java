package com.examly.springapp.service;

import java.util.Optional;

import com.examly.springapp.model.LoanModel;
import com.examly.springapp.repository.LoanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CustomerService {
	@Autowired
	LoanRepository repo;

	public LoanModel getCustomer(String id) {
		LoanModel p=new LoanModel();
		for(LoanModel obj : repo.findAll())
		{
			if((obj.getApplicantEmail())!=null) {
			if((obj.getApplicantEmail()).equals(id))
			{
				p=obj;
			}
			}
		}
		return p;
	}
	public Optional<LoanModel> getCustomer(Long id) {
		return repo.findById(id);
	}
}
