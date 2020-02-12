package com.ibm.employee;

import java.sql.*;
import java.util.*;

public class Employee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int n;
		Scanner sc = new Scanner(System.in);
		//Load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Connect to the db
		Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		
		System.out.println("Successfully Connected to DataBase...");
		
		while(true) {
			System.out.println("\n1. Add employee\n2. Display employee\n3. Update employee\n4. Delete employee\nEnter the option:");
			n = sc.nextInt();
			switch(n) {
			case 1:
				new Employee().insertData(dbCon);
				break;
			case 2:
				new Employee().displayData(dbCon);
				break;
			case 3:
				new Employee().updateData(dbCon);
				break;
			case 4:
				new Employee().deleteData(dbCon);
				break;
			default:
				System.out.println("Enter correct option!!!");
				break;
			}
		}

	}
	
	// Inserts a new row into the table: userDetails
	void insertData(Connection dbCon) {
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the ID: ");
//		int id = sc.nextInt();
		System.out.println("Enter the name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter the designation: ");
		String designation = sc.nextLine();
		System.out.println("Enter the salary: ");
		int salary = sc.nextInt();
		try {
			//Write the query to insert a new row in table
			String insertQry = "INSERT INTO employeedetails(userName, userSalary, userDesignation) values (?, ?, ?)";
			PreparedStatement stmt = dbCon.prepareStatement(insertQry);
			
			//stmt.setInt(1, id);
			stmt.setString(1, name);
			stmt.setInt(2, salary);
			stmt.setString(3, designation);
			//Execute the query
			int row = stmt.executeUpdate();
//			System.out.println(row);
			
		} catch (SQLException e) {
			System.out.println("Issues creating the statement :" + e.getMessage());
		}
	}
	
		void deleteData(Connection dbCon) {
			//Write the query to delete a new row in table
			Scanner sc = new Scanner(System.in);
			String deleteQry = "delete from employeedetails where userID = ?";
			
			System.out.println("Enter the ID of the employee: ");
			int n = sc.nextInt();
			//Create the Statement
			try {
				PreparedStatement stmt = dbCon.prepareStatement(deleteQry);
				
				stmt.setInt(1, n);
				
				//Execute the query
				int m = stmt.executeUpdate();
//				System.out.println(m);
				
			} catch (SQLException e) {
				System.out.println("Issues creating the statement :" + e.getMessage());
			}
		}
		
		void displayData(Connection dbCon) {
			//Write the query to delete a new row in table
			Scanner sc = new Scanner(System.in);
			String selectQry = "select * from employeedetails where userID = ?";
			
			System.out.println("Enter the ID of the employee: ");
			int n = sc.nextInt();
			//Create the Statement
			try {
				PreparedStatement stmt = dbCon.prepareStatement(selectQry);
				
				stmt.setInt(1, n);
				
				//Execute the query
				stmt.execute();
				
			} catch (SQLException e) {
				System.out.println("Issues creating the statement :" + e.getMessage());
			}
		}
		
		void updateData(Connection dbCon) {
			//Write the query to delete a new row in table
			Scanner sc = new Scanner(System.in);
			String selectQry = "UPDATE employeedetails SET useName=?, userSalary=?, userDesignation=? WHERE userID=?";
			
			System.out.println("Enter the ID of the employee: ");
			int n = sc.nextInt();
			//Create the Statement
			try {
				PreparedStatement stmt = dbCon.prepareStatement(selectQry);
				
				System.out.println("Enter name: ");
				String name = sc.nextLine();
				name = sc.nextLine();
				System.out.println("Enter salary: ");
				int salary = sc.nextInt();
				System.out.println("Enter designation: ");
				String designation = sc.nextLine();
				designation = sc.nextLine();
				stmt.setString(1, name);
				stmt.setInt(2, salary);
				stmt.setString(3, designation);
				stmt.setInt(4, n);
				
				//Execute the query
				stmt.execute();
				
			} catch (SQLException e) {
				System.out.println("Issues creating the statement :" + e.getMessage());
			}
		}
}
