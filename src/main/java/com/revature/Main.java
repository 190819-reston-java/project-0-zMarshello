package com.revature;


import org.apache.log4j.Logger;

import com.revature.controller.InitiationScreen;
/** 
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */
public class Main {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(InitiationScreen.class);
		logger.info("Starting application");
		InitiationScreen.determineExistingUser();
	}
}
