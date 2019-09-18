package com.revature.service;

import com.revature.exception.InvalidPasswordException;

public interface PasswordRequirements {
	
	public static boolean checkPassword(String s){
		boolean containsNumber;
		boolean containsUpper;
		boolean containsSpecial;
		boolean containsLower;
		try {
			containsNumber = false;
			containsUpper = false;
			containsSpecial = false;
			containsLower = false;
			String[] numArray = {"0", "1","2","3","4","5","6","7","8","9"};
			String[] upperArray = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
			String[] lowerArray = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
			String[] specialArray = {"!","@","#","$","%","^","&","*","?","<", ">"};
			String[] strArray = s.split("");
			for(String str: strArray) {
				for(String strUp : upperArray) {
					if(str.equals(strUp)) {
						containsUpper = true;
					}
				}
				for(String strNum : numArray) {
					if(str.equals(strNum)) {
						containsNumber = true;
					}
				}
				for(String strLower : lowerArray) {
					if(str.equals(strLower)) {
						containsLower = true;
					}
				}
				for(String strSpecial : specialArray) {
					if(str.equals(strSpecial)) {
						containsSpecial = true;
					}
				}
				if(containsLower && containsUpper && containsNumber && containsSpecial) {
					return true;
				}
			}

		} catch (InvalidPasswordException e) {
			System.out.println("Sorry, failed to create password");
			System.out.println("received: " + e.getMessage());
			return false;
		}
		
		return false;
	
	}

}
