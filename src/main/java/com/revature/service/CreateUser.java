package com.revature.service;


import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.controller.InitiationScreen;
import com.revature.model.User;
import com.revature.repository.CustomerDAO;
import com.revature.repository.CustomerDAOimpPJDBC;


public class CreateUser {

	public static Logger logger = Logger.getLogger(InitiationScreen.class);
	
	public static User createUser() {
		
		Scanner sc = new Scanner(System.in);
		User newUser = new User();
		CustomerDAO dao = new CustomerDAOimpPJDBC();
		
		System.out.println("Welcome to Marshello National Bank!");
		System.out.println("Let's go ahead and create a new account just for you!");
		System.out.println("Here, we will collect all information needed to help you get started.");
		System.out.println("First, What is your FIRST NAME?");
		newUser.setName(sc.nextLine());
		logger.debug("Received user input: " + newUser.getName());
		System.out.println("Great! Now, what would you like your USERNAME to be?");
		newUser.setUsername(sc.nextLine());
		logger.debug("Received user input: " + newUser.getUsername());
		createPassword(newUser);
		logger.debug("Received user input: " + newUser.getPassword());
		System.out.println("Excellent! To confirm, your new password is " + newUser.getPassword());
		System.out.println("Last thing before we finsih creating your new account. Would you like to make an initial deposit?");
		System.out.println("1 -- Yes");
		System.out.println("2 -- No");
		
		switch(sc.nextLine()) {
		case "1":
			System.out.println("Ok great! How much would you like your initial deposit to be?");
			double deposit = Double.parseDouble(TerminalActions.inputSanitize(sc.nextLine()));
			newUser.setBalance(deposit);
			logger.debug("Received user input: " + newUser.getBalance());
			dao.createUserDAO(newUser);
			break;
		case "2":
			System.out.println("Ok, no problem. We will just setup your new account for now.");
			System.out.println("Please come back and see us anytime when you are ready to make a deposit.");
			dao.createUserDAO(newUser);
			break;
		default:
			System.out.println("Invalid Selection. Try again.");
			logger.debug("Selection was not recognized");
			logger.debug("Restarting application");
			createUser();
		}
		return newUser;
	}
	
	public static void createPassword(User u) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ok, now, please enter a PASSWORD for your new account and make sure you write it down so you don't forget it for future use.");
		System.out.println("Password must contain at least ONE of EACH of the following: ");
		System.out.println("Uppercase letter: a-z");
		System.out.println("Lowercase Letter: A-Z");
		System.out.println("Number: 0-9");
		System.out.println("Symbol: !, @, #, $, %, ^, &, *, <, >, ?");
		String enteredPassword = sc.nextLine();
		if(PasswordRequirements.checkPassword(enteredPassword)) {
			u.setPassword(enteredPassword);
		} else {
			System.out.println("Invalid entry. Try again. Check password requirements");
			createPassword(u);
		}
		
	}

}
