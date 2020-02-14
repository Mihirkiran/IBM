package com.ibm.wallet.service;

import java.sql.ResultSet;
import java.util.Date;

import com.ibm.wallet.bean.Customer;

public interface WalletServiceInterface {
	public void createAccount(Customer cust);
	public void deposit(int amt, String userID);
	public boolean withdraw(int amt, String userID);
	public void fundTransfer(String fromUserID, String toUserID, int amt, Date date);
	public ResultSet printTransactions(String userID);
	public int getBalance(String userID);
}
