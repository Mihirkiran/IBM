package com.ibm.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBFetchValues {
	public ResultSet getValues() {
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibm20Jan", "root", "");
			
			Statement stmt = dbCon.createStatement();
			
			  rs = stmt.executeQuery("select * from userDetails");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Can't load the driver for mysql: " + e.getMessage());
			
		}
		finally {
			return rs;
		}
	}
}
