package com.examly.springapp.repository;

import com.examly.springapp.model.LoanModel;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<LoanModel, Integer>{

   

  //void deleteByLoanId(int id);

    LoanModel findByLoanId(int id);

}
