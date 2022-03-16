package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.LoanApplicantModel;

@Repository
public interface LoanApplicantRepository extends JpaRepository<LoanApplicantModel, Long> {
	LoanApplicantModel findByLoanId(Long id);
}
