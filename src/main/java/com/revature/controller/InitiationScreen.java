package com.revature.controller;

import java.util.Scanner;

import com.revature.model.User;
import com.revature.repository.CustomerDAO;
import com.revature.repository.CustomerDAOimpPJDBC;
import com.revature.service.CreateUser;
import com.revature.service.Login;

public class InitiationScreen {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void determineExistingUser() {
		System.out.println("Greetings from Marshello National Bank!");
		System.out.println("Do you need to :");
		System.out.println("1 -- 'Create a New Account?'");
		System.out.println("2 -- 'Login to existing account?'");
		String userSelection = sc.nextLine();
		
		switch(userSelection) {
		case "1":			
			String un = CreateUser.createUser().getUsername();
			CustomerDAO dao = new CustomerDAOimpPJDBC();
			User user = dao.getUserDAO(un);			
			UserMenu.mainMenu(user);			
			break;
		case "2":
			Login log = new Login();
			log.loginAttempt();			
			break;
		default:
			System.out.println("Invalid Selection. Try again.");
			determineExistingUser();
		}
		
		
	}

}
