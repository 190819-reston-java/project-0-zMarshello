package com.revature.service;

import com.revature.model.User;
import com.revature.repository.CustomerDAO;
import com.revature.repository.CustomerDAOimpPJDBC;

public class DAOActions {
	/*
	 * Takes a user object and creates CustomerDAO. It then recaptures CustomerDAO from database.
	 * This allows a new user object to receive a database assigned ID number for further object manipulation and use
	 */
	public static User createCustomerDAOGetCustomerDAO(User u) {
		
		CustomerDAO dao = new CustomerDAOimpPJDBC();
		dao.createUserDAO(u);
		System.out.println(u);
		dao.getUserDAO(u.getUsername());
		System.out.println(u);
		return u;
	}
	
	

}
