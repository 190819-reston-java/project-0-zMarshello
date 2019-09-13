package com.revature.service;

import java.util.Scanner;

import com.revature.controller.UserMenu;
import com.revature.model.User;
import com.revature.repository.CustomerDAO;
import com.revature.repository.CustomerDAOimpPJDBC;

public class Login {

	private String enteredUsername;
	private String enteredPassword;
	private boolean loggedIn = false;
	
	User user = new User();
	
	int failedLoginAttemptCounter = 0;
	
	private static Scanner sc = new Scanner(System.in);

	
	public void loginAttempt() {
		enterCredentials();
		if(checkCredentials()) {
			successfulLogin();
		} else {
			unseccessfulLogin();
		}
		
	}
	
	
	
	private void unseccessfulLogin() {
		failedLoginAttemptCounter++;
		if (failedLoginAttemptCounter > 4) {
			System.out.println("You have failed login too many times! Your account it temporarilly locked.");
			System.out.println("Please try agian in 15 minutes. Goodbye.");
			System.exit(1);
		}
		System.out.println("Your Username and/or Password did not match our records.");
		System.out.println("Please try again.");
		loginAttempt();
	}

	private void successfulLogin() {
		System.out.println("Username and Password successfully verified, press enter to continue to main menu.");
		sc.nextLine();
		UserMenu.mainMenu(user);
	}

	public void enterCredentials()	{
		System.out.println("Please enter your username and password below.");
		System.out.print("Username: ");
		this.enteredUsername = sc.nextLine();
		System.out.print("Password: ");
		this.enteredPassword = sc.nextLine();
	}
	
	public boolean checkCredentials() {
		CustomerDAO dao = new CustomerDAOimpPJDBC();
		user = dao.getUserDAO(enteredUsername, enteredPassword);
		if(user == null) {
			return false;
		} else {
			
			return true;
		}
		
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	
	
	
		
}
