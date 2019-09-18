package com.revature.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.service.TerminalActions;

public class TerminalActionsTest {

	@Before
	public void setupString() {
		
	}
	
	@Test
	public void sanitizeNumber() {
		String s = "$120,000.50";
		Double d = Double.valueOf(TerminalActions.inputSanitize(s));
		System.out.println(d);
	}
	
	@Test
	public void sanitizeNegetiveNumberInput() {
		String s = "-12000.00";
		Double d = Double.valueOf(TerminalActions.inputSanitize(s));
		System.out.println(d);
	}
	
	@Test(expected = NumberFormatException.class)
	public void sanitizeNonNumberInput() {
		String s = "Seven Thousand";
		Double d = Double.valueOf(TerminalActions.inputSanitize(s));
		System.out.println(d);
	}
	
	
	@After
	public void tearDownString() {
		
	}

}
