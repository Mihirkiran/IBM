package com.ibm.wallet.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ibm.wallet.bean.*;
import com.ibm.wallet.service.*;

@Component("ui")
public class UI {
	
	@Autowired
	WalletService ws;
	@Autowired
	Customer cust;
	@Autowired
	Customer custRecieve;
	public void main() throws SQLException {		
		String userName, userID, phoneNumber, fromUserID, toUserID;
		int amt = 0;
		boolean flag;
//		WalletService ws = context.getBean("WalletService", WalletService.class);
		
		
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
//					cust = context.getBean("Customer", Customer.class);
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
//					cust = context.getBean("Customer", Customer.class);
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
//					cust = context.getBean("Customer", Customer.class);
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
//					cust = context.getBean("Customer", Customer.class);
//					Customer custRecieve = context.getBean("Customer", Customer.class);
					cust.setUserID(fromUserID);
//					custRecieve.setUserID(toUserID);
//					System.out.println(cust.getUserID());
//					System.out.println(custRecieve.getUserID());
					flag = ws.fundTransfer(cust, toUserID, amt, date);
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
					List<Transaction> lst = ws.printTransactions(userID);
					
					if(lst.size() == 0) {
						System.out.println("No Transaction History!!!");
					}
					else {
						System.out.println(lst);
						break;
					}
					
					break;
				case 6:
					System.out.println("Enter your User ID: ");
					sc.nextLine();
					userID = sc.nextLine();
//					cust = context.getBean("Customer", Customer.class);
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


