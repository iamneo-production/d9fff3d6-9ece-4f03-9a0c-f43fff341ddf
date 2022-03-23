package com.examly.springapp.controller;


import com.examly.springapp.model.LoginModel;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
// @CrossOrigin(origins = "https://8081-ddcadebbdcbcecbaaeddadfaadaeaacdfed.examlyiopb.examly.io/")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
	AuthService callservice;
	
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
