package com.revature.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionHistory {

	int transactionID;
	private Date transactionDate = new Date();
	private double transactionAmmount;
	private String transactionType;

	
	public TransactionHistory(int transactionID, Date transactionDate, double transactionAmmount,
			String transactionType) {
		super();
		this.transactionID = transactionID;
		this.transactionDate = transactionDate;
		this.transactionAmmount = transactionAmmount;
		this.transactionType = transactionType;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
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
	
}
