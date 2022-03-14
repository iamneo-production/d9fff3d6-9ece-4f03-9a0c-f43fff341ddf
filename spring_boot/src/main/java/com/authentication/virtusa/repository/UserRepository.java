package com.authentication.virtusa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authentication.virtusa.model.UserModel;



@Repository
public interface UserRepository extends JpaRepository<UserModel, String>{

	UserModel findByEmail(String email);


	

}
