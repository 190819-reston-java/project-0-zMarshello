package com.revature.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.service.PasswordRequirements;

public class PasswordRequirementTest implements PasswordRequirements {

	@Before
	public void setupString() {
		
	}
	
	@Test
	public void PasswordRequirementTest() {
		String s = "P@ssword1";
		System.out.println(PasswordRequirements.checkPassword(s));
	}
	
	@After
	public void tearDownString() {
		
	}

}
