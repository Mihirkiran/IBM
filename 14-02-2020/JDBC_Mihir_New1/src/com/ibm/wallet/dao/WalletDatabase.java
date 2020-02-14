package com.ibm.wallet.dao;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

import com.ibm.wallet.bean.Customer;
import com.ibm.wallet.service.WalletService;

public class WalletDatabase implements WalletDatabaseInterface{
	
	Connection dbCon;
	
	public WalletDatabase() {
		//Load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		
			// System.out.println("Successfully Connected to DataBase...");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean createAccount(Customer cust) {
		try {
			//Write the query to insert a new row in table
			String insertQry = "INSERT INTO userdetails values (?, ?, ?, ?)";
			PreparedStatement stmt = dbCon.prepareStatement(insertQry);
			
			stmt.setString(1, cust.getUserID());
			stmt.setString(2, cust.getUserName());
			stmt.setInt(3, cust.getBalance());
			stmt.setString(4, cust.getPhoneNumber());
			//Execute the query
			int a = stmt.executeUpdate();
			if(a > 0) {
//				System.out.println("Account successfully created!!!");
				return true;
			}
			else {
				return false;
			}
			
		} catch (SQLException e) {
//			System.out.println("Issues creating the statement :" + e.getMessage());
			return false;
		}
	}
	
	@Override
	public int getBalance(String userID) {
		int b = 0;
		try {
			String selectQry = "select balance from userdetails where userID = ?";
			
			PreparedStatement stmt = dbCon.prepareStatement(selectQry);
			stmt.setString(1, userID);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("balance");
			}
			else {
				return -1;
				// return (Integer) null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	@Override
	public boolean deposit(int amt, String userID) {
		String updateQry = "UPDATE userdetails SET balance=? WHERE userID=?";


		try {
			PreparedStatement stmt = dbCon.prepareStatement(updateQry);
			
			stmt.setInt(1, getBalance(userID) + amt);
			stmt.setString(2, userID);
			int a = stmt.executeUpdate();
			if(a == 0) {
//				System.out.println("Account does not exist!!!");
				return false;
			}
			else {
//				System.out.println(amt + " deposited!!!");
				return true;
			}
			
		} catch (SQLException e) {
//			System.out.println("Issues creating the statement :" + e.getMessage());
			return false;
		}
	}
	@Override
	public boolean withdraw(int amt, String userID) {
		String updateQry = "UPDATE userdetails SET balance=? WHERE userID=?";

		try {
			PreparedStatement stmt = dbCon.prepareStatement(updateQry);
			
			stmt.setInt(1, getBalance(userID) - amt);
			stmt.setString(2, userID);
			
			//Execute the query
			int a = stmt.executeUpdate();
			if(a == 0) {
//				System.out.println("Account does not exist!!!");
				return false;
			}
			else {
//				System.out.println(amt + " withdrawn!!!");
				return true;
			}
			
		} catch (SQLException e) {
//			System.out.println("Issues creating the statement :" + e.getMessage());
			return false;
		}
	}
	@Override
	public boolean fundTransfer(String fromUserID, String toUserID, int amt, String date) {
		boolean b = new WalletService().withdraw(amt, fromUserID);
		if(b == true) {
			boolean f = deposit(amt, toUserID);
			if(f == false) {
				deposit(amt, fromUserID);
				return false;
			}
			try {
				//Write the query to insert a new row in table
				String insertQry = "INSERT INTO transactiondetails(fromUserID, toUserID, amount, transactionTime) values (?, ?, ?, ?)";
				PreparedStatement stmt = dbCon.prepareStatement(insertQry);
				
				stmt.setString(1, fromUserID);
				stmt.setString(2, toUserID);
				stmt.setInt(3, amt);
				stmt.setString(4, date);
				//Execute the query
				stmt.executeUpdate();
//				System.out.println(amt + " transferred to recipient!!!");
				return true;
			} catch (SQLException e) {
//				System.out.println("Issues creating the statement :" + e.getMessage());
				return false;
			}
		}
		else {
//			System.out.println("Insufficient funds!!!");
			return false;
		}
	}
	@Override
	public ResultSet printTransaction(String userID) {
		ResultSet rs = null;
		try {
			String selectQry = "select * from transactiondetails where fromUserID = ? or toUserID = ?";
			
			PreparedStatement stmt = dbCon.prepareStatement(selectQry);
			stmt.setString(1, userID);
			stmt.setString(2, userID);
			
			rs = stmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return rs;
	}
}
