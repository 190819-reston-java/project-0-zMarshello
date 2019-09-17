package com.revature.repository;

import com.revature.model.User;

public interface CustomerDAO {
	
	User getUserDAO(String username);
	boolean updateUser(User u);
	boolean createUserDAO(User u);
	User getUserDAO(String username, String password);

}
