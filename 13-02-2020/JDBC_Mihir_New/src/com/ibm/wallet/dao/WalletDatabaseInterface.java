package com.ibm.wallet.dao;

import java.sql.ResultSet;
import java.util.Date;

import com.ibm.wallet.bean.Customer;

public interface WalletDatabaseInterface {
	public void createAccount(Customer cust);
	public int getBalance(String userID);
	public void deposit(int amt, String userID);
	public void withdraw(int amt, String userID);
	public void fundTransfer(String fromID, String toID, int amt, String date);
	public ResultSet printTransaction(String userID);
}
