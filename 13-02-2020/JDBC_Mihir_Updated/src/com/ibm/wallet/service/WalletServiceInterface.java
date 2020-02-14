package com.ibm.wallet.service;

import java.sql.ResultSet;
import java.util.Date;

import com.ibm.wallet.bean.Customer;

public interface WalletServiceInterface {
	public boolean createAccount(Customer cust);
	public boolean deposit(int amt, Customer cust);
	public boolean withdraw(int amt, Customer cust);
	public boolean fundTransfer(Customer fromUserID, Customer toUserID, int amt, Date date);
	public ResultSet printTransactions(String userID);
	public int getBalance(Customer cust);
}
