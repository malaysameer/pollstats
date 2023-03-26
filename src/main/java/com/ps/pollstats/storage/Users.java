package com.ps.pollstats.storage;

import java.util.ArrayList;
import java.util.List;

import com.ps.pollstats.model.User;

public class Users {
	private List<User> userList;
	  
    // Method to return the list
    // of users
    public List<User> getUserList()
    {
  
        if (userList == null) {
  
            userList
                = new ArrayList<>();
  
                   
        }
  
        return userList;
  
           
    }
  
    public void
    setUserList(
        List<User> employeeList)
    {
        this.userList
            = userList;
    }
}
