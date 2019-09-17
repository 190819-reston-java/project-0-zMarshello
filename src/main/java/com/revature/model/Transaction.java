package com.revature.model;

import java.text.DecimalFormat;

public class Transaction {

	int transactionID;
	private String transactionDate;
	private double transactionAmmount;
	private String transactionType;
	private int customerId;
	
	public Transaction() {
		
	}

	
	public Transaction(int transactionID, String transactionDate, double transactionAmmount,
			String transactionType, int customerId) {
		super();
		this.transactionID = transactionID;
		this.transactionDate = transactionDate;
		this.transactionAmmount = transactionAmmount;
		this.transactionType = transactionType;
		this.customerId = customerId;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public double getTransactionAmmount() {
		return transactionAmmount;
	}
	public void setTransactionAmmount(double transactionAmmount) {
		this.transactionAmmount = transactionAmmount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	@Override
	public String toString() {
		DecimalFormat df2 = new DecimalFormat("#.00");
		return "Transaction ID: " + transactionID + ", Transaction Date: " + transactionDate
				+ ", Transaction Ammount: $" + df2.format(transactionAmmount) + ", Transaction Type: " + transactionType
				+ ", Customer ID: " + customerId;
	}
	
	
}
