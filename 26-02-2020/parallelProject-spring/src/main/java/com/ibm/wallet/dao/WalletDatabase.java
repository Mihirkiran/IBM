package com.ibm.wallet.dao;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.RowMapper;
import com.ibm.wallet.bean.Customer;
import com.ibm.wallet.bean.Transaction;
import com.ibm.wallet.service.WalletService;

@Repository
public class WalletDatabase {
	
	DataSource dataSource;
	NamedParameterJdbcTemplate namedParam;
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		namedParam = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public boolean createAccount(Customer cust) throws SQLException {
		//Write the query to insert a new row in table
		String insertQry = "INSERT INTO userdetails values (:userID, :userName, :balance, :phoneNumber)";
			
		int a = namedParam.update(insertQry, new MapSqlParameterSource("userID", cust.getUserID()).addValue("userName", cust.getUserName()).addValue("balance", cust.getBalance()).addValue("phoneNumber", cust.getPhoneNumber()));
		
		if(a > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getBalance(Customer cust) throws SQLException {
		String selectQry = "select balance from userdetails where userID = :userID";
		
		return namedParam.queryForObject(selectQry, 
				new MapSqlParameterSource("userID", cust.getUserID())
				, Integer.class);
	}
	public boolean deposit(int amt, Customer cust) throws SQLException {
		String updateQry = "UPDATE userdetails SET balance=:balance WHERE userID=:userID";

		int a = namedParam.update(updateQry, new MapSqlParameterSource("userID", cust.getUserID()).addValue("balance", cust.getBalance() + amt));

		if(a == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean withdraw(int amt, Customer cust) throws SQLException {
		String updateQry = "UPDATE userdetails SET balance=:balance WHERE userID=:userID";

		int a = namedParam.update(updateQry, new MapSqlParameterSource("userID", cust.getUserID()).addValue("balance", cust.getBalance() - amt));

		if(a == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean fundTransfer(Customer fromUserID, Customer toUserID, int amt, String date) throws BeansException, SQLException {
		boolean b = context.getBean("WalletService", WalletService.class).withdraw(amt, fromUserID);
		if(b == true) {
			try {
				boolean f = deposit(amt, toUserID);
				if(f == false) {
					deposit(amt, fromUserID);
					return false;
				}
				String insertQry = "INSERT INTO transactiondetails values (:fromUserID, :toUserID, :amount, :transactionTime)";
				namedParam.update(insertQry, new MapSqlParameterSource("fromUserID", fromUserID.getUserID()).addValue("toUserID", toUserID.getUserID()).addValue("amount", amt).addValue("transactionTime", date));

				return true;
			} catch (SQLException e) {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public List<Transaction> printTransaction(String userID) throws SQLException {
		String selectQry = "select * from transactiondetails where fromUserID = :fromUserID or toUserID = :toUserID";
		
		return namedParam.query(selectQry, 
				new MapSqlParameterSource("toUserID", userID)
				.addValue("fromUserID", userID)
				, new UserMapper());
		
	}
	class UserMapper implements RowMapper<Transaction>{
		public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException{
			Transaction tran = context.getBean("Transaction", Transaction.class);
			tran.setFromUserID(rs.getString("fromUserID"));
			tran.setToUserID(rs.getString("toUserID"));
			tran.setAmount(rs.getInt("amount"));
			tran.setTransactionTime(rs.getString("transactionTime"));
			return tran;
		}
			
	}
}
