package com.ps.pollstats.repository;

import org.springframework.stereotype.Repository;

import com.ps.pollstats.model.User;
import com.ps.pollstats.storage.Users;

@Repository
public class UserDAO {
	private static Users list
    = new Users();

	// This static block is executed
	// before executing the main
	// block
	static
	{
	
	    // Creating a few employees
	    // and adding them to the list
	    list.getUserList().add(
	        new User(
	            1,
	            "Prem",
	            "Tiwari",
	            "chapradreams@gmail.com"));
	
	    list.getUserList().add(
	        new User(
	            2, "Vikash",
	            "Kumar",
	            "abc@gmail.com"));
	
	    list.getUserList().add(
	        new User(
	            3, "Ritesh",
	            "Ojha",
	            "asdjf@gmail.com"));
	
	       
	}

	// Method to return the list
	public Users getAllUsers()
	{
	    return list;
	}
	
	   
	// Method to add a user
	// to the users list
	public void addUser(User user)
	{
	    list.getUserList()
	        .add(user);
	}
}
