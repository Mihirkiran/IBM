package com.ibm.wallet.bean;

import org.springframework.stereotype.Component;

@Component("tran")
public class Transaction {
	String fromUserID, toUserID, transactionTime;
	int amount;
	public String getFromUserID() {
		return fromUserID;
	}
	public void setFromUserID(String fromUserID) {
		this.fromUserID = fromUserID;
	}
	public String getToUserID() {
		return toUserID;
	}
	public void setToUserID(String toUserID) {
		this.toUserID = toUserID;
	}
	public String getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String toString(){
		return "From: " + getFromUserID() 
				+ "To: " + getToUserID() 
				+ "Amount: " + getAmount()
				+ "Time: " + getTransactionTime() + "\n";
				
	}
}
