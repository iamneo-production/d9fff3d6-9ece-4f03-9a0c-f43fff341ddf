package com.authentication.virtusa.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.virtusa.model.LoginModel;
import com.authentication.virtusa.model.UserModel;
import com.authentication.virtusa.service.AuthService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	AuthService callservice;

	public AuthController(AuthService callservice) {
		super();
		this.callservice = callservice;
	}
	
	@PostMapping("/saveUser")
	public boolean saveUser(@RequestBody UserModel user)
	{
		return callservice.saveUser(user);
	}
	@PostMapping("/isUserPresent")
	public boolean isUserPresent(@RequestBody LoginModel data)
	{
		return callservice.check(data);
	}
}
