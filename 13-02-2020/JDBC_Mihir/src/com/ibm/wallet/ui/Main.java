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
		int amt;
		WalletService ws = new WalletService();
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = 0;
			System.out.println("\n1. Create account\n"
					+ "2. Deposit\n"
					+ "3. Withdraw\n"
					+ "4. Fund Transfer\n"
					+ "5. Print Transactions\n"
					+ "Enter your option: ");
			n = sc.nextInt();
			switch(n) {
				case 1:
					System.out.println("Enter your Name: ");
					sc.nextLine();
					userName = sc.nextLine();
					System.out.println("Enter your Phone Number: ");
					phoneNumber = sc.nextLine();
					System.out.println("Enter your User ID: ");
					userID = sc.nextLine();
					Customer cust = new Customer();
					cust.setBalance(0);
					cust.setPhoneNumber(phoneNumber);
					cust.setUserID(userID);
					cust.setUserName(userName);
					ws.createAccount(cust);
					System.out.println("Account successfully created!!!");
					break;
				case 2:
					System.out.println("Enter your User ID: ");
					sc.nextLine();
					userID = sc.nextLine();
					System.out.println("Enter the amount to be deposited: ");
					amt = sc.nextInt();
					ws.deposit(amt, userID);
					// System.out.println(amt + " deposited!!!");
					break;
				case 3:
					System.out.println("Enter your User ID: ");
					sc.nextLine();
					userID = sc.nextLine();
					System.out.println("Enter the amount to be withdrawn: ");
					amt = sc.nextInt();
					ws.withdraw(amt, userID);
					// System.out.println(amt + " withdrawn!!!");
					break;
				case 4:
					System.out.println("Enter your User ID: ");
					sc.nextLine();
					fromUserID = sc.nextLine();
					System.out.println("Enter your Recipient User ID: ");
					toUserID = sc.nextLine();
					System.out.println("Enter the amount to be transferred: ");
					amt = sc.nextInt();
					Date date = Calendar.getInstance().getTime();
					ws.fundTransfer(fromUserID, toUserID, amt, date);
					//System.out.println(amt + " transferred to recipient!!!");
					break;
				case 5:
					System.out.println("Enter your User ID: ");
					sc.nextLine();
					userID = sc.nextLine();
					ResultSet rs = ws.printTransactions(userID);
					
					while(rs.next()) {
						System.out.println("From: " + rs.getString("fromUserID") + " "
								+ "To: " + rs.getString("toUserID") + " "
										+ "Amount: " + rs.getInt("amount") + " "
												+ "Time: " + rs.getString("transactionTime"));
					}
					
					break;
			}
		}

	}

}
