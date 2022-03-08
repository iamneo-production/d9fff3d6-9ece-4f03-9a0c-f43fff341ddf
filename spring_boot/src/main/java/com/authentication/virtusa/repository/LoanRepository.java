package com.authentication.virtusa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authentication.virtusa.model.LoanModel;

public interface LoanRepository extends JpaRepository<LoanModel, Integer>{

}
