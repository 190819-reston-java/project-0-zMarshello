package com.revature.service;


import java.util.Scanner;


import com.revature.model.User;
import com.revature.repository.CustomerDAO;
import com.revature.repository.CustomerDAOimpPJDBC;


public class CreateUser {

	public static User createUser() {
		
		Scanner sc = new Scanner(System.in);
		User newUser = new User();
		
		
		
		
		System.out.println("Welcome to Marshello National Bank!");
		System.out.println("Let's go ahead and create a new account just for you!");
		System.out.println("Here, we will collect all information needed to help you get started.");
		System.out.println("First, What is your FIRST NAME?");
		newUser.setName(sc.nextLine());
		System.out.println("Great! Now, what would you like your USERNAME to be?");
		newUser.setUsername(sc.nextLine());
		System.out.println("Ok, now, please enter a PASSWORD for your new account and make sure you srite it down so you don't forget it for futeure use.");
		newUser.setPassword(sc.nextLine());
		System.out.println("Excellent! To confirm, your new password is " + newUser.getPassword());
		CustomerDAO dao = new CustomerDAOimpPJDBC();
		System.out.println("Last thing before we finsih creating your new account. Would you like to make an initial deposit?");
		System.out.println("1 -- Yes");
		System.out.println("2 -- No");
		if(sc.nextLine().equals("1")) {
			System.out.println("Ok great! How much would you like your initial deposit to be?");
			double deposit = Double.parseDouble(TerminalActions.inputSanitize(sc.nextLine()));
			newUser.setBalance(deposit);
			dao.createUserDAO(newUser);
		}else if(sc.nextLine().equals("2")) {
			System.out.println("Ok, no problem. We will just setup your new account for now.");
			System.out.println("Please come back and see us anytime when you are ready to make a deposit.");
			newUser.setBalance(0);
			dao.createUserDAO(newUser);
		}
		return newUser;
	}

}
