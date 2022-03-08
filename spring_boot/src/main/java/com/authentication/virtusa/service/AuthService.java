package com.authentication.virtusa.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.virtusa.model.LoginModel;
import com.authentication.virtusa.model.UserModel;
import com.authentication.virtusa.repository.UserRepository;

@Service
public class AuthService {
	@Autowired
	UserRepository repo;
	
	public boolean saveUser(UserModel user){
		try {
		int temp=0;
		for(UserModel obj : repo.findAll())
		{
			if(obj.getEmail().equals(user.getEmail()))
			{
				temp=1;
				break;
			}
		}
		if(temp==0) {
			repo.save(user);
			return true;
		}}
		catch(Exception e)
		{
			System.out.print(e);
		}
		return false;
	}
	public boolean check(LoginModel data) {					
		UserModel obj=repo.findByEmail(data.getEmail());
		//System.out.print(obj.getEmail()+" "+obj.getPassword()+" "+data.getEmail()+" "+data.getPassword());
		if((data.getEmail().equals(obj.getEmail())) && (data.getPassword().equals(obj.getPassword())))
			return true;
		else if(data.getPassword().equals("admin") && data.getEmail().equals("admin"))
			return true;
		else
			return false;
	}
}
