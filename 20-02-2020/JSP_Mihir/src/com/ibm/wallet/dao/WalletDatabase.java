package com.ibm.wallet.dao;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import com.ibm.wallet.bean.Customer;
//import com.ibm.wallet.service.WalletService;

public class WalletDatabase implements WalletDatabaseInterface{
	
	Connection dbCon;
	
	public WalletDatabase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean createAccount(Customer cust) {
		try {
			//Write the query to insert a new row in table
			String insertQry = "INSERT INTO userdetails values (?, ?, ?, ?, ?)";
			PreparedStatement stmt = dbCon.prepareStatement(insertQry);
			
			stmt.setString(1, cust.getUserID());
			stmt.setString(2, cust.getPassword());
			stmt.setString(3, cust.getUserName());
			stmt.setInt(4, cust.getBalance());
			stmt.setString(5, cust.getPhoneNumber());
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
			return false;
		}
	}
	
	@Override
	public int getBalance(Customer cust) {
		int b = 0;
		try {
//			System.out.println(cust.getUserID());
			String selectQry = "select balance from userdetails where userID = ?";
			
			PreparedStatement stmt = dbCon.prepareStatement(selectQry);
			stmt.setString(1, cust.getUserID());
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("balance");
			}
			else {
				return -1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	@Override
	public boolean deposit(int amt, Customer cust) {
		String updateQry = "UPDATE userdetails SET balance=? WHERE userID=?";


		try {
			PreparedStatement stmt = dbCon.prepareStatement(updateQry);
			
			stmt.setInt(1, getBalance(cust) + amt);
//			System.out.println(getBalance(cust) + amt);
			stmt.setString(2, cust.getUserID());
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
	public boolean withdraw(int amt, Customer cust) {
		String updateQry = "UPDATE userdetails SET balance=? WHERE userID=?";

		try {
			PreparedStatement stmt = dbCon.prepareStatement(updateQry);
			
			stmt.setInt(1, getBalance(cust) - amt);
			stmt.setString(2, cust.getUserID());
			
			int a = stmt.executeUpdate();
			if(a == 0) {
				return false;
			}
			else {
				return true;
			}
			
		} catch (SQLException e) {
			return false;
		}
	}
	@Override
	public boolean fundTransfer(Customer fromUserID, Customer toUserID, int amt, String date) {
		boolean b = false;
		if(getBalance(fromUserID) >= amt) {
			withdraw(amt, fromUserID);
			b = true;
		}
//		boolean b = new WalletService().withdraw(amt, fromUserID);
		
		if(b == true) {
			boolean f = deposit(amt, toUserID);
			if(f == false) {
				deposit(amt, fromUserID);
				return false;
			}
			try {
				String insertQry = "INSERT INTO transactiondetails(fromUserID, toUserID, amount, transactionTime) values (?, ?, ?, ?)";
				PreparedStatement stmt = dbCon.prepareStatement(insertQry);
				
				stmt.setString(1, fromUserID.getUserID());
				stmt.setString(2, toUserID.getUserID());
				stmt.setInt(3, amt);
				stmt.setString(4, date);
				stmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				return false;
			}
		}
		else {
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
			return null;
		}
		return rs;
	}
	@Override
	public boolean validate(Customer cust) {
		String p ="";
		String selectQry = "select * from userdetails where userID = ?";
        boolean flag = false;
		ResultSet rs;
		try {
			PreparedStatement stmt = dbCon.prepareStatement(selectQry);
			stmt.setString(1, cust.getUserID());
			rs = stmt.executeQuery();
			if(rs.next()) {
	        	p = rs.getString("password"); 
	        }
		} catch (SQLException e) {
			flag = false;
		} 

        if(cust.getPassword().equals(p)){  
        	flag = true;
        } 
		return flag;
	}

}
