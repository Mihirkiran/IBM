package com.ibm.wallet.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import com.ibm.wallet.bean.*;
import com.ibm.wallet.service.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		String userName, userID, phoneNumber, fromUserID, toUserID;
		int amt = 0;
		WalletService ws = new WalletService();
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = 0;
			System.out.println("\n1. Create account\n"
					+ "2. Deposit\n"
					+ "3. Withdraw\n"
					+ "4. Fund Transfer\n"
					+ "5. Print Transactions\n"
					+ "6. Get Balance\n"
					+ "Enter your option: ");
			n = sc.nextInt();
			switch(n) {
				case 1:
					System.out.println("Enter your Name (Should be less than 30 characters): ");
					sc.nextLine();
					userName = sc.nextLine();
					if(userName.length() > 30) {
						System.out.println("Error!!!");
						break;
					}
					System.out.println("Enter your Phone Number (Should be 10 digits or less): ");
					phoneNumber = sc.nextLine();
					if(phoneNumber.length() > 10) {
						System.out.println("Error!!!");
						break;
					}
					System.out.println("Enter your User ID (Should be less than 10 characters): ");
					userID = sc.nextLine();
					if(userID.length() > 10) {
						System.out.println("Error!!!");
						break;
					}
					Customer cust = new Customer();
					cust.setBalance(0);
					cust.setPhoneNumber(phoneNumber);
					cust.setUserID(userID);
					cust.setUserName(userName);
					ws.createAccount(cust);
					// System.out.println("Account successfully created!!!");
					break;
				case 2:
					System.out.println("Enter your User ID (Should be less than 10 characters): ");
					sc.nextLine();
					userID = sc.nextLine();
					if(userID.length() > 10) {
						System.out.println("Error!!!");
						break;
					}
					System.out.println("Enter the amount to be deposited: ");
					if(sc.hasNextInt() == false) {
						System.out.println("Enter valid amount!!!");
						sc.nextLine();
						break;
					}
					amt = sc.nextInt();
					ws.deposit(amt, userID);
					// System.out.println(amt + " deposited!!!");
					break;
				case 3:
					System.out.println("Enter your User ID (Should be less than 10 characters): ");
					sc.nextLine();
					userID = sc.nextLine();
					if(userID.length() > 10) {
						System.out.println("Error!!!");
						break;
					}
					System.out.println("Enter the amount to be withdrawn: ");
					if(sc.hasNextInt() == false) {
						System.out.println("Enter valid amount!!!");
						sc.nextLine();
						break;
					}
					amt = sc.nextInt();
					ws.withdraw(amt, userID);
					// System.out.println(amt + " withdrawn!!!");
					break;
				case 4:
					System.out.println("Enter your User ID (Should be less than 10 characters): ");
					sc.nextLine();
					fromUserID = sc.nextLine();
					if(fromUserID.length() > 10) {
						System.out.println("Error!!!");
						break;
					}
					System.out.println("Enter your Recipient User ID (Should be less than 10 characters): ");
					toUserID = sc.nextLine();
					if(toUserID.length() > 10) {
						System.out.println("Error!!!");
						break;
					}
					System.out.println("Enter the amount to be transferred: ");
					if(sc.hasNextInt() == false) {
						System.out.println("Enter valid amount!!!");
						sc.nextLine();
						break;
					}
					amt = sc.nextInt();
					Date date = Calendar.getInstance().getTime();
					ws.fundTransfer(fromUserID, toUserID, amt, date);
					//System.out.println(amt + " transferred to recipient!!!");
					break;
				case 5:
					System.out.println("Enter your User ID (Should be less than 10 characters): ");
					sc.nextLine();
					userID = sc.nextLine();
					if(userID.length() > 10) {
						System.out.println("Error!!!");
						break;
					}
					ResultSet rs = ws.printTransactions(userID);
					
					while(rs.next()) {
						System.out.println("From: " + rs.getString("fromUserID") + " "
								+ "To: " + rs.getString("toUserID") + " "
										+ "Amount: " + rs.getInt("amount") + " "
												+ "Time: " + rs.getString("transactionTime"));
					}
					
					break;
				case 6:
					System.out.println("Enter your User ID: ");
					sc.nextLine();
					userID = sc.nextLine();
					int bal = ws.getBalance(userID);
					System.out.println("Balance is: " + bal);
					break;
				default:
					System.out.println("Enter correct option!!!");
					break;
			}
		}

	}

}
