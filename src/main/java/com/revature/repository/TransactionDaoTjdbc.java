package com.revature.repository;

import com.revature.model.Transaction;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;
import com.revature.util.StreamCloser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoTjdbc implements TransactionDAO {

	@Override
	public boolean createTransactionDAO(Transaction t, User u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String query = "INSERT INTO postgres.project0.transactionS VALUES (DEFAULT, ?, ?, ?, ?);";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, t.getTransactionDate());
			stmt.setDouble(2, t.getTransactionAmmount());
			stmt.setString(3, t.getTransactionType());
			stmt.setInt(4, u.getId());
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
		
		return true;
	}

	@Override
	public List<Transaction> getTransactionHistory(User u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Transaction> transHistory = new ArrayList<Transaction>();
		String query = "SELECT * FROM project0.transactions WHERE customer_id =?;";
		
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, u.getId());
			stmt.execute();
			rs = stmt.getResultSet();
				while(rs.next()) {
					transHistory.add(new Transaction(
								 rs.getInt("transaction_id"),
								 rs.getString("transaction_timestamp"),
								 rs.getDouble("transaction_ammount"),
								 rs.getString("transaction_type"),
								 rs.getInt("customer_id"))
								 );
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			StreamCloser.close(rs);
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
		
		return transHistory;
	}

}
