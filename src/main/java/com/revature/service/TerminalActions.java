package com.revature.service;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.controller.InitiationScreen;
import com.revature.controller.UserMenu;
import com.revature.exception.InvalidInputException;
import com.revature.model.Transaction;
import com.revature.model.User;
import com.revature.repository.CustomerDAO;
import com.revature.repository.CustomerDAOimpPJDBC;
import com.revature.repository.TransactionDAO;
import com.revature.repository.TransactionDaoTjdbc;
public class TerminalActions {
	
	static Scanner sc = new Scanner(System.in);
	private static CustomerDAO dao = new CustomerDAOimpPJDBC();
	private static DecimalFormat df2 = new DecimalFormat("#.00");
	private static TransactionDAO transDao = new TransactionDaoTjdbc();
	public static Logger logger = Logger.getLogger(TerminalActions.class);
	
	
	public static void exit() {
		System.out.println("Thanks for using Marshello National Bank");
		System.out.println("Goodbye!");
		System.exit(1);
	}
	
	public static void viewTransactionHistory(User u) {
		System.out.println("Transaction History: ");
		for (Transaction t : transDao.getTransactionHistory(u)) {
			System.out.println(t);
		}
		newTransaction(u);
	}

	public static void takeWithdrawl(User passedUser) {
		
		double balance = passedUser.getBalance();
		Transaction trans = new Transaction();
		
		System.out.println("Hello, please enter the amount you would like to withdrawl.");
		double userWithdrawlAmmount = Double.parseDouble(inputSanitize(sc.nextLine()));
		logger.debug("Received user input: " + userWithdrawlAmmount);
		try {
			if (overdraftCheck(balance, userWithdrawlAmmount)) {
				Date date = new Date();
				passedUser.setBalance(balance -= userWithdrawlAmmount);
				trans.setTransactionAmmount(userWithdrawlAmmount);
				trans.setTransactionDate(new Timestamp(date.getTime()).toString());
				trans.setTransactionType("withdrawl");
				dao.updateUser(passedUser);
				transDao.createTransactionDAO(trans, passedUser);
				System.out.println("We processed your withdrawl of $" + df2.format(userWithdrawlAmmount) + " please take your cash below.");
				newTransaction(passedUser);
			}else {
				UserMenu.mainMenu(passedUser);
			}
		} catch (InvalidInputException e) {
			e.printStackTrace();
		} 
		
	}
/*
 * makeDeposit takes in a User Object and allows console user to input a deposit amount. 
 * It then adds that amount to the user's balance and updates the DAO pushing an update to the DB.
 */
	public static void makeDeposit(User passedUser) {
		Date date = new Date();
		Transaction trans = new Transaction();
		double balance = passedUser.getBalance();
		
		System.out.println("Hello, please enter the ammount you would like to deposit below.");
		System.out.print("Ammount to deposit: ");
		double userDepositAmmount = Double.parseDouble(inputSanitize(sc.nextLine()));
		logger.debug("Received user input: " + userDepositAmmount);
		passedUser.setBalance(balance += userDepositAmmount); 
		trans.setTransactionAmmount(userDepositAmmount);
		trans.setTransactionDate(new Timestamp(date.getTime()).toString());
		trans.setTransactionType("deposit");
		dao.updateUser(passedUser);
		transDao.createTransactionDAO(trans, passedUser);
		System.out.println("Thank you. We have processed your deposit of $" + df2.format(userDepositAmmount) + ".");
		newTransaction(passedUser);
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
	
	private static boolean overdraftCheck(double balance, double deduction) throws InvalidInputException {
		double check = balance - deduction;
		
		if(check < 0) {
			System.out.println("Deduction amount too large. Overdrafting not allowed. Please enter new amount.");
			return false;
		} else if (check >= 0) {
			return true;
		} else {
			throw new InvalidInputException();
		}
	}
	
	public static String inputSanitize(String s) {
		StringBuilder sb = new StringBuilder();
		String[] strArray = s.split("");
		String[] sNumArray = {"0","1","2","3","4","5","6","7","8","9", "."};
		for (String str : strArray) {
			for(String strN : sNumArray) {
				if (str.equals(strN)) {
					sb.append(str);
				}
			}
		}
		String sanitizedString = sb.toString();
		return sanitizedString;
	}

}
