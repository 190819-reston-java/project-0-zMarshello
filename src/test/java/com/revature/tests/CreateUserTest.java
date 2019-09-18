package com.revature.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.service.CreateUser;

public class CreateUserTest extends CreateUser {

	@Before
	public void setup() {
		
	}
	
	@Test
	public void CreateUserTest() {
		System.out.println(createUser());
	}
	
	@After
	public void tearDown() {
		
	}

}
