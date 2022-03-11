
package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
//      public User findByEmailIdAndId(String emailId,int id);
	  public User findByEmailId(String emailId);
        public User findByEmailIdAndPassword(String email,String password);
//      public User getUser(int id);
}
