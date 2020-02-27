package com.ibm.wallet.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.ibm.wallet.bean.Customer;
import com.ibm.wallet.bean.Transaction;
import com.ibm.wallet.dao.WalletDatabase;

@Service("ws")
public class WalletService {
//    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
	
	@Autowired
	WalletDatabase wd;
	public boolean createAccount(Customer cust) throws SQLException {
		boolean flag = wd.createAccount(cust);
		return flag;
	}
	public boolean deposit(int amt, Customer cust) throws SQLException {
		boolean flag = wd.deposit(amt, cust);
		return flag;
	}
	public boolean withdraw(int amt, Customer cust) throws SQLException {
		boolean b = true;
		int bal = wd.getBalance(cust);
		if(bal == -1) {
			return false;
		}
		if(amt <= bal) {
			b = wd.withdraw(amt, cust);
			// System.out.println(amt + " withdrawn!!!");
		}
		else {
			b = false;
		}
		return b;
	}
	public boolean fundTransfer(Customer fromUserID, Customer toUserID, int amt, Date date) throws BeansException, SQLException {
		String pattern = "MM/dd/yyyy HH:mm:ss";

		DateFormat df = new SimpleDateFormat(pattern);

		Date today = Calendar.getInstance().getTime();        

		String todayAsString = df.format(today);
		return wd.fundTransfer(fromUserID, toUserID, amt, todayAsString);
	}
	public List<Transaction> printTransactions(String userID) throws SQLException {
		return wd.printTransaction(userID);
	}
	public int getBalance(Customer cust) throws SQLException {
		return wd.getBalance(cust);
	}
}
