package com.revature.controller;

import java.util.Scanner;


import com.revature.service.DAOActions;
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
			UserMenu.mainMenu(DAOActions.createCustomerDAOGetCustomerDAO(CreateUser.createUser()));
			
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
