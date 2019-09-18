package com.revature.model;

public class User {
	
	private int id;
	private String name;
	private String username;
	private String password;
	private double balance = 0.00;
	
	
	
	public User(int id, String name, String username, String password, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	
	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", password=" + password + ", balance=" + balance
				+ "]";
	}
	
	

}
