package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;

@Service
public class UserService {
     
	@Autowired
	private UserRepository repo; 
	
	public User saveUser(User user) {
		return  repo.save(user);
	}
	
//	public User fetchUserByEmailIdAndId(String email,int id) {
//		return repo.findByEmailIdAndId(email,id);
//	}
	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	public User fetchUserByEmailIdAndPassword(String email,String password) {
		return repo.findByEmailIdAndPassword(email,password);
	}

	
//	public User getUser(int id) {
//		return repo.getById(id);
//	}
	
}
