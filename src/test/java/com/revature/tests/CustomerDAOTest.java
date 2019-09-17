package com.revature.tests;

import org.junit.Test;

import com.revature.model.User;
import com.revature.repository.CustomerDAO;
import com.revature.repository.CustomerDAOimpPJDBC;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class CustomerDAOTest {
	
	@Before
	public void setUpUserObject() {
	}
	
	
	@Test
	public void returnUserWithUsernameMatch() {
		CustomerDAO cDAO = new CustomerDAOimpPJDBC();
		User u = new User();
		u.setUsername("marsh3825");
		String username = u.getUsername();
		assertTrue((cDAO.getUserDAO(u.getUsername())).getUsername().equals(username));
	}
	
	@After
	public void tearDown() {
	}
	
}
