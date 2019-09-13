package com.revature.controller;

import java.util.Scanner;
import java.util.stream.Stream;

import com.revature.exception.InvalidSelectionException;
import com.revature.model.User;
import com.revature.service.TerminalActions;

public class UserMenu {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void mainMenu(User user) {
		System.out.println("Hello " + user.getName().toUpperCase() + "!");
		System.out.println("Welcome to Marshello National Bank");
		System.out.println("Please select one of the following options.");
		System.out.println("1: View Balance");
		System.out.println("2: Make Deposit");
		System.out.println("3: Take Withdrawl");
		System.out.println("4: Logout");
		
		String userMenuSelection = sc.nextLine();
		
		try {
			switch(userMenuSelection) {
			case "1": 
				TerminalActions.viewBalance(user);
				break;
			case"2":
				TerminalActions.makeDeposit(user);
				break;
			case "3":
				TerminalActions.takeWithdrawl(user);
				break;
			case "4":
				TerminalActions.exit();
			default:
				System.out.println("Invalid input");
				mainMenu(user);
			}
		} catch (InvalidSelectionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			mainMenu(user);
		}
		
	}

}
