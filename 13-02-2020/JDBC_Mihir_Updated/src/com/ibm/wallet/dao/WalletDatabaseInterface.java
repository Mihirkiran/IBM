package com.ibm.wallet.dao;

import java.sql.ResultSet;
import java.util.Date;

import com.ibm.wallet.bean.Customer;

public interface WalletDatabaseInterface {
	public boolean createAccount(Customer cust);
	public int getBalance(Customer cust);
	public boolean deposit(int amt, Customer cust);
	public boolean withdraw(int amt, Customer cust);
	public boolean fundTransfer(Customer fromID, Customer toID, int amt, String date);
	public ResultSet printTransaction(String userID);
}
