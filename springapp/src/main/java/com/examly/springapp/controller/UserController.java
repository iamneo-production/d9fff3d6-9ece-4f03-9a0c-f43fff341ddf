package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;

@RestController
// @CrossOrigin(origins="http://localhost:8081")
// @CrossOrigin("https://8081-dafccccadbcbffcbaaeddadfaadaeaacdfed.examlyiopb.examly.io/")
@CrossOrigin("*")
public class UserController {
	
     @Autowired
     private UserService service; 
     
     @RequestMapping("/welcome")
     public String welcome() {
    	 String text="this is private page";
    	 text+= "this page is not allowed to unauthenticated user";
    	 return text;
     }
     
     @PostMapping("/signup")
    //  @CrossOrigin(origins="http://localhost:8081")
	 @CrossOrigin("*")
	 public User registerUser(@RequestBody User user) throws Exception {
    	 String tempEmailId=user.getEmailId();
    	 
//    	 int tempId=user.getId();
//    	 if((tempEmailId != null && !"".equals(tempEmailId)) || (tempId !=0 && !"".equals(tempId)) ) {
//    		 User userobj=service.fetchUserByEmailIdAndId(tempEmailId,tempId);
    	 
    	 if(tempEmailId != null && !"".equals(tempEmailId)) {
    		 User userobj=service.fetchUserByEmailId(tempEmailId);
    		 
    	     if(userobj !=null) {
    		    throw new Exception("User With "+tempEmailId+" And is already exist");
    	     }
    	 }
    	 User userObj=null;  
		 userObj=service.saveUser(user);
		 return userObj;
	 }
     
     @PostMapping("/login")
     @CrossOrigin("*")
	//  @CrossOrigin(origins="http://localhost:8081")
     public User loginUser(@RequestBody User user) throws Exception{
    	 String tempEmailId=user.getEmailId();
    	 String tempPassword=user.getPassword();
    	 User userObj=null;
    	 if(tempEmailId !=null && tempPassword !=null) {
    		userObj= service.fetchUserByEmailIdAndPassword(tempEmailId, tempPassword);
    	 }
    	 if(userObj == null) {
    		 throw new Exception ("Bad Credential");
    	 }
    	 return userObj;
     }
     
//     @GetMapping("/login/{courseId}")
//     public User getUserById(@PathVariable String id)    {
//    	 return this.service.getUser(Integer.parseInt(id));
//     }

}
 