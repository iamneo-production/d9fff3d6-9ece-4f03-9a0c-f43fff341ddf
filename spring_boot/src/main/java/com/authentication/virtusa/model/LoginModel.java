package com.authentication.virtusa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class LoginModel {
	@Id
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public LoginModel() {
		super();
		// TODO Auto-generated constructor stub
	}
}
