package com.revature.repository;


import java.util.List;

import com.revature.model.Transaction;
import com.revature.model.User;

public interface TransactionDAO {

	boolean createTransactionDAO(Transaction t, User u);
	List<Transaction> getTransactionHistory(User u);

}
