package com.examly.springapp.model;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
//  @GeneratedValue(strategy= GenerationType.IDENTITY)
   @Id
   private int id;
   private String emailId;
   private String userName;
   private String mobNo;
   private String password;  
   
public User() {

}
public User(int id, String emailId, String userName,String mobNo, String password) {
	super();
	this.id = id;
	this.emailId = emailId;
	this.userName = userName;
	this.mobNo=mobNo;
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMobNo() {
	return mobNo;
}
public void setMobNo(String mobNo) {
	this.mobNo = mobNo;
}
   
}
