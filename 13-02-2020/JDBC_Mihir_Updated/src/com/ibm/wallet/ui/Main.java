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
		Customer cust;
		String userName, userID, phoneNumber, fromUserID, toUserID;
		int amt = 0;
		boolean flag;
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
					+ "7. Exit\n"
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
					cust = new Customer();
					cust.setBalance(0);
					cust.setPhoneNumber(phoneNumber);
					cust.setUserID(userID);
					cust.setUserName(userName);
					flag = ws.createAccount(cust);
					if(flag == true)
						System.out.println("Account successfully created!!!");
					else
						System.out.println("Issues in creating the account!!!");
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
					cust = new Customer();
					cust.setUserID(userID);
					flag = ws.deposit(amt, cust);
					if(flag == true)
						System.out.println(amt + " deposited!!!");
					else
						System.out.println("Issues in depositing the amount!!!\n"
								+ "Check account number!!!");
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
					cust = new Customer();
					cust.setUserID(userID);
					flag = ws.withdraw(amt, cust);
					if(flag == true)
						 System.out.println(amt + " withdrawn!!!");
					else
						System.out.println("Issues in withdrawing the amount!!!");
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
					cust = new Customer();
					Customer custRecieve = new Customer();
					cust.setUserID(fromUserID);
					custRecieve.setUserID(toUserID);
					flag = ws.fundTransfer(cust, custRecieve, amt, date);
					if(flag == true)
						System.out.println(amt + " transferred to recipient!!!");
					else
						System.out.println("Issues in transferring the amount!!!");
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
					
					if(rs == null) {
						System.out.println("Error!!!");
					}
					if(rs.next()) {
						while(rs.next()) {
							System.out.println("From: " + rs.getString("fromUserID") + " "
									+ "To: " + rs.getString("toUserID") + " "
											+ "Amount: " + rs.getInt("amount") + " "
													+ "Time: " + rs.getString("transactionTime"));
						}
					}
					else {
						System.out.println("No transaction history");
					}
					break;
				case 6:
					System.out.println("Enter your User ID: ");
					sc.nextLine();
					userID = sc.nextLine();
					cust = new Customer();
					cust.setUserID(userID);
					int bal = ws.getBalance(cust);
					if(bal >= 0)
						System.out.println("Balance is: " + bal);
					else
						System.out.println("Issues in getting the balance!!!\n"
								+ "Check account number!!!");
					break;
				case 7:
					System.out.println("Thank You!!!");
					System.exit(0);
				default:
					System.out.println("Enter correct option!!!");
					break;
			}
		}

	}

}
