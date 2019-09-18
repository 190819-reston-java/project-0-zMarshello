package com.revature.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.model.User;
import com.revature.service.CreateUser;

public class CreatePasswordTest {
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void returnValidPassowrd() {
		User u;
		CreateUser.createPassword(u = new User());
	}
	
	@After
	public void tearDown() {
		
	}

}
