package com.ibm.wallet.service;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.ibm.wallet.bean.Customer;
import com.ibm.wallet.dao.WalletDatabase;

public class WalletService implements WalletServiceInterface{
	WalletDatabase wd = new WalletDatabase();
	@Override
	public boolean createAccount(Customer cust) {
		boolean flag = wd.createAccount(cust);
		return flag;
	}
	@Override
	public boolean deposit(int amt, Customer cust) {
		boolean flag = wd.deposit(amt, cust);
		return flag;
	}
	@Override
	public boolean withdraw(int amt, Customer cust) {
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
//			System.out.println("Insufficient Balance!!!");
			b = false;
		}
		return b;
	}
	@Override
	public boolean fundTransfer(Customer fromUserID, Customer toUserID, int amt, Date date) {
		String pattern = "MM/dd/yyyy HH:mm:ss";

		DateFormat df = new SimpleDateFormat(pattern);

		Date today = Calendar.getInstance().getTime();        

		String todayAsString = df.format(today);
		return wd.fundTransfer(fromUserID, toUserID, amt, todayAsString);
	}
	@Override
	public ResultSet printTransactions(String userID) {
		return wd.printTransaction(userID);
	}
	@Override
	public int getBalance(Customer cust) {
		return wd.getBalance(cust);
	}
}
