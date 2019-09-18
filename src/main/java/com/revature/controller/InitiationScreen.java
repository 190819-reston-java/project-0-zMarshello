package com.revature.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.model.User;
import com.revature.repository.CustomerDAO;
import com.revature.repository.CustomerDAOimpPJDBC;
import com.revature.service.CreateUser;
import com.revature.service.Login;

public class InitiationScreen {
	
	static Scanner sc = new Scanner(System.in);
	public static Logger logger = Logger.getLogger(InitiationScreen.class);
	
	public static void determineExistingUser() {
		
		System.out.println("Greetings from Marshello National Bank!");
		System.out.println("Do you need to :");
		System.out.println("1 -- 'Create a New Account?'");
		System.out.println("2 -- 'Login to existing account?'");
		String userSelection = sc.nextLine();
		logger.info("Received user input: " + userSelection);
		
		switch(userSelection) {
		case "1":	
			User u = CreateUser.createUser();
			CustomerDAO dao = new CustomerDAOimpPJDBC();
			User user = dao.getUserDAO(u.getUsername());
			UserMenu.mainMenu(user);			
			break;
		case "2":
			Login log = new Login();
			log.loginAttempt();			
			break;
		default:
			System.out.println("Invalid Selection. Try again.");
			logger.debug(userSelection + " was not recognized");
			logger.debug("Restarting application");
			determineExistingUser();
		}
		
		
	}

}
