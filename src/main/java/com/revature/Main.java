package com.revature;


import com.revature.controller.CreateUser;
import com.revature.controller.InitiationScreen;
import com.revature.model.TransactionHistory;
import com.revature.model.User;
import com.revature.repository.CustomerDAO;
import com.revature.repository.CustomerDAOimpPJDBC;
import com.revature.util.ConnectionUtil;

/** 
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */
public class Main {

	public static void main(String[] args) {
		
		InitiationScreen.determineExistingUser();
		
	}
}
