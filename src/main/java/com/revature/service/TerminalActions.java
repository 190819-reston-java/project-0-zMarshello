package com.revature.service;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.revature.controller.UserMenu;
import com.revature.model.User;
import com.revature.repository.CustomerDAO;
import com.revature.repository.CustomerDAOimpPJDBC;
public class TerminalActions {
	
	static Scanner sc = new Scanner(System.in);
	private static CustomerDAO dao = new CustomerDAOimpPJDBC();
	private static DecimalFormat df2 = new DecimalFormat("#.00");
	
	
	public static void exit() {
		System.out.println("Thanks for using Marshello National Bank");
		System.out.println("Goodbye!");
		System.exit(1);
	}

	public static void takeWithdrawl(User passedUser) {
		User user = passedUser;
		double balance = user.getBalance();
		
		System.out.println("Hello, please enter the amount you would like to withdrawl.");
		double userWithdrawlAmmount = Double.parseDouble(sc.nextLine());
		user.setBalance(balance -= userWithdrawlAmmount);
		dao.updateUser(user);
		System.out.println("We processed your withdrawl of $" + df2.format(userWithdrawlAmmount) + " please take your cash below.");
		newTransaction(user);
	}
/*
 * makeDeposit takes in a User Object and allows console user to input a deposit amount. 
 * It then adds that amount to the user's balance and updates the DAO pushing an update to the DB.
 */
	public static void makeDeposit(User passedUser) {
		User user = passedUser;
		double balance = user.getBalance();
		
		System.out.println("Hello, please enter the ammount you would like to deposit below.");
		System.out.print("Ammount to deposit: ");
		double userDepositAmmount = Double.parseDouble(sc.nextLine());
		user.setBalance(balance += userDepositAmmount); ;
		dao.updateUser(user);
		System.out.println("Thank you. We have processed your deposit of $" + df2.format(userDepositAmmount) + ".");
		newTransaction(user);
	}

	

	public static void viewBalance(User passedUser) {
		User user = passedUser;
		
		System.out.println("Your balance is $" + df2.format(user.getBalance()) + ".");
		
		newTransaction(user);
	}
	
/*
 * Prompts console user to select if they would like to continue in the app.
 */
	private static void newTransaction(User u) {
		System.out.println("Would you like to make another transaction?");
		System.out.println("'1' -- Yes");
		System.out.println("'2' -- No");
		
		String userMenuSelection = sc.nextLine();
		switch(userMenuSelection) {
		case "1":
			UserMenu.mainMenu(u);
			break;
		case "2":
			exit();
		default:
			System.out.println("Invalid Selection. Try again");
			newTransaction(u);
		}
		
	}

}
