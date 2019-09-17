package com.revature.repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.User;import com.revature.util.ConnectionUtil;
import com.revature.util.StreamCloser;

public class CustomerDAOimpPJDBC implements CustomerDAO {

	
	
	@Override
	public User getUserDAO(String username) {
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		User user = null;
		
		try {
			conn = ConnectionUtil.getConnection();
			
			stmt = conn.prepareStatement("SELECT * FROM postgres.project0.customer WHERE username =?;");
			stmt.setString(1, username);
			if(stmt.execute()) {
				resultSet = stmt.getResultSet();
				if(resultSet.next()) {
					user = new User(resultSet.getInt("customerid"), 
							resultSet.getString("name"), 
							resultSet.getString("username"), 
							resultSet.getString("password"), 
							resultSet.getDouble("balance"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			StreamCloser.close(resultSet);
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
		
		return user;
	}

	@Override
	public boolean createUserDAO(User u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String query = "INSERT INTO postgres.project0.customer VALUES (DEFAULT, ?, ?, ?, ?);";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getUsername());
			stmt.setString(3, u.getPassword());
			stmt.setBigDecimal(4, BigDecimal.valueOf(u.getBalance()));
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
		
		return true;
	}

	@Override
	public boolean updateUser(User u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		final String query = "UPDATE postgres.project0.customer SET name=?, username=?, password=?, balance=? WHERE customerid=?;";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getUsername());
			stmt.setString(3, u.getPassword());
			stmt.setDouble(4, u.getBalance());
			stmt.setInt(5, u.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
		
		return true;
	}

	@Override
	//used for validating login for existing user
	public User getUserDAO(String username, String password) {
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		User user = null;
		
		try {
			conn = ConnectionUtil.getConnection();
			//System.out.println(username + " & " + password);
			stmt = conn.prepareStatement("SELECT * FROM postgres.project0.customer WHERE username =? AND password=?;");
			stmt.setString(1, username);
			stmt.setString(2, password);
			if(stmt.execute()) {
				resultSet = stmt.getResultSet();
				if(resultSet.next()) {
					user = new User(resultSet.getInt("customerid"), 
							resultSet.getString("name"), 
							resultSet.getString("username"), 
							resultSet.getString("password"), 
							resultSet.getDouble("balance"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			StreamCloser.close(resultSet);
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
		
		return user;
	}
		
}
