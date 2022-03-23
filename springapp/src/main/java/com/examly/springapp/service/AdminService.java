package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import com.examly.springapp.model.LoanModel;
import com.examly.springapp.repository.LoanRepository;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class AdminService {
	@Autowired
	LoanRepository loanrepo;
	
	public List<LoanModel> getAll() {
		return loanrepo.findAll();
	}
	public String deleteCustomer(Long id) {
		loanrepo.deleteById(id);
		return "deleted";
	}

	public LoanModel getCustomer(Long id) {
		return loanrepo.findByLoanId(id);
	}
	public LoanModel editCustomer(LoanModel t, Long id) {
		Optional<LoanModel> find=loanrepo.findById(id);
		if(find.isPresent())
		{
			t.setLoantype(t.getLoantype());
			t.setApplicantName(t.getApplicantName());
			t.setApplicantAadhar(t.getApplicantAadhar());
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
	public boolean approve(Long id) {
		LoanModel l=loanrepo.findByLoanId(id);
		l.setApprej("app");
		loanrepo.save(l);
		return true;
	}
	public boolean reject(Long id) {
		LoanModel l=loanrepo.findByLoanId(id);
		l.setApprej("rej");
		loanrepo.save(l);
		return false;
	}
	
}
