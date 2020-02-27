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

@Repository("wd")
public class WalletDatabase {
	
	DataSource dataSource;
	NamedParameterJdbcTemplate namedParam;
//    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
	
//	@Autowired
//	Transaction tran;
	
	@Autowired
	WalletService ws;
	
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

		int a = namedParam.update(updateQry, new MapSqlParameterSource("userID", cust.getUserID()).addValue("balance", getBalance(cust) + amt));

		if(a == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean withdraw(int amt, Customer cust) throws SQLException {
		String updateQry = "UPDATE userdetails SET balance=:balance WHERE userID=:userID";

		int a = namedParam.update(updateQry, new MapSqlParameterSource("userID", cust.getUserID()).addValue("balance", getBalance(cust) - amt));

		if(a == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean fundTransfer(Customer fromUserID, String toUserID, int amt, String date) throws BeansException, SQLException {
		boolean b = false;
		if(amt <= getBalance(fromUserID)) {
			
			b = withdraw(amt, fromUserID);
		}
		else {
			return false;
		}
		if(b == true) {
			Customer c1 = new Customer();
			c1.setUserID(toUserID);
			try {
				boolean f = deposit(amt, c1);
				if(f == false) {
					deposit(amt, fromUserID);
					return false;
				}
				String insertQry = "INSERT INTO transactiondetails(fromUserID, toUserID, amount, transactionTime) values (:fromUserID, :toUserID, :amount, :transactionTime)";
				namedParam.update(insertQry, new MapSqlParameterSource("fromUserID", fromUserID.getUserID()).addValue("toUserID", toUserID).addValue("amount", amt).addValue("transactionTime", date));

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
			Transaction tran = new Transaction();
			tran.setFromUserID(rs.getString("fromUserID"));
			tran.setToUserID(rs.getString("toUserID"));
			tran.setAmount(rs.getInt("amount"));
			tran.setTransactionTime(rs.getString("transactionTime"));
			return tran;
		}
			
	}
}
