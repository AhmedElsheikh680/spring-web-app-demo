package com.seniorsteps.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seniorsteps.dao.UserDAO;
import com.seniorsteps.model.User;

@RestController
@RequestMapping("/api/v1/user")
public class UserApiController {
	
	@Autowired 
	private UserDAO userDao;
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> allUsers(){
		if(true) {
			throw new RuntimeException("Exception Happened");
		}
		List<User> users = userDao.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}

}
