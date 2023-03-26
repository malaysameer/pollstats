package com.ps.pollstats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ps.pollstats.model.User;
import com.ps.pollstats.repository.UserDAO;
import com.ps.pollstats.storage.Users;
import java.net.URI;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserDAO userDao;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public Users getUsers()
	{  
	  return userDao
	         .getAllUsers();
	}
	
	
	// Create a POST method
    // to add a user
    // to the list
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> addUser(@RequestBody User user)
	{

	    // Creating an ID of a user
	    // from the number of users
	    Integer id
	        = userDao
	              .getAllUsers()
	              .getUserList()
	              .size()
	          + 1;
	
	    user.setId(id);
	
	    userDao
	        .addUser(user);
	
	    URI location
	        = ServletUriComponentsBuilder
	              .fromCurrentRequest()
	              .path("/{id}")
	              .buildAndExpand(
	                  user.getId())
	              .toUri();
	
	           return ResponseEntity
	        .created(location)
	        .build();
	}
}
