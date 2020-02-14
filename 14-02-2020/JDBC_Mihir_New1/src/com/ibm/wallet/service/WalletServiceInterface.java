package com.ibm.wallet.service;

import java.sql.ResultSet;
import java.util.Date;

import com.ibm.wallet.bean.Customer;

public interface WalletServiceInterface {
	public boolean createAccount(Customer cust);
	public boolean deposit(int amt, String userID);
	public boolean withdraw(int amt, String userID);
	public boolean fundTransfer(String fromUserID, String toUserID, int amt, Date date);
	public ResultSet printTransactions(String userID);
	public int getBalance(String userID);
}
