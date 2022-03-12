package com.authentication.virtusa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.authentication.virtusa.model.LoanModel;
import com.authentication.virtusa.repository.LoanRepository;


@Service
public class AdminService {
	@Autowired
	LoanRepository loanrepo;

	public List<LoanModel> getAll() {
		return loanrepo.findAll();
	}
	public String deleteCustomer(int id) {
		loanrepo.deleteById(id);
		return "deleted";
	}

	public Optional<LoanModel> getCustomer(int id) {
		return loanrepo.findById(id);
	}
	public LoanModel editCustomer(LoanModel t, int id) {
		Optional<LoanModel> find=loanrepo.findById(id);
		if(find.isPresent())
		{
			t.setLoantype(t.getLoantype());
			t.setApplicantName(t.getApplicantName());
			t.setApplicantAadharr(t.getApplicantAadharr());
			t.setApplicantAddress(t.getApplicantAddress());
			t.setApplicantEmail(t.getApplicantEmail());
			t.setApplicantMobile(t.getApplicantMobile());
			t.setApplicantPan(t.getApplicantPan());
			t.setApplicantSalary(t.getApplicantSalary());
			t.setLoanAmountRequired(t.getLoanAmountRequired());
			t.setRepaymentMonths(t.getRepaymentMonths());
			loanrepo.save(t);
		}
		return t;
	}
	public boolean approve(int id) {
		LoanModel l=loanrepo.getById(id);
		l.setApprej("app");
		loanrepo.save(l);
		return true;
	}
	public boolean reject(int id) {
		LoanModel l=loanrepo.getById(id);
		l.setApprej("rej");
		loanrepo.save(l);
		return false;
	}
	
}
