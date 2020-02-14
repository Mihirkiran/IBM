package com.ibm.wallet.dao;

import java.sql.ResultSet;
import java.util.Date;

import com.ibm.wallet.bean.Customer;

public interface WalletDatabaseInterface {
	public boolean createAccount(Customer cust);
	public int getBalance(String userID);
	public boolean deposit(int amt, String userID);
	public boolean withdraw(int amt, String userID);
	public boolean fundTransfer(String fromID, String toID, int amt, String date);
	public ResultSet printTransaction(String userID);
}
