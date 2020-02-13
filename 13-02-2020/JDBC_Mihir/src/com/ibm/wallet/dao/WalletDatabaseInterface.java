package com.ibm.wallet.dao;

import java.sql.ResultSet;
import java.util.Date;

public interface WalletDatabaseInterface {
	public void createAccount(String userName, String userID, int balance, String phoneNumber);
	public int getBalance(String userID);
	public void deposit(int amt, String userID);
	public void withdraw(int amt, String userID);
	public void fundTransfer(String fromID, String toID, int amt, String date);
	public ResultSet printTransaction(String userID);
}
