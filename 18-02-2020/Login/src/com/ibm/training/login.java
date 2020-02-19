package com.ibm.training;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
@WebServlet("/loginpage")
public class login extends HttpServlet { 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException { 
//    	HttpSession session;
    	String p = "";
    	Connection dbCon = null;
    	ResultSet rs;
        PrintWriter out=response.getWriter(); 
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    	catch (ClassNotFoundException e) {
    		System.out.println("jksdnbkdjs");
		}
    	        
    	
	    	response.setContentType("text/html");  
	 
	        request.getRequestDispatcher("link.html").include(request, response);  
	          
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	          
	        String selectQry = "select * from userdetails where userID = ?";
	        
			try {
				PreparedStatement stmt = dbCon.prepareStatement(selectQry);
				stmt.setString(1, name);
				rs = stmt.executeQuery();
	//			p = rs.getString("password");
				if(rs.next()) {
		        	p = rs.getString("password"); 
		        }
			} catch (SQLException e) {
				System.out.println("ABC");
			} catch (NullPointerException e) {
				System.out.println("DEF");
			}
	
	        if(password.equals(p)){  
	        	out.print("Welcome, "+name);  
	        	HttpSession session=request.getSession();  
	        	session.setAttribute("name",name);  
	        }  
	        else{  
	            out.print("Sorry, username or password error!");  
	            request.getRequestDispatcher("login.html").include(request, response);  
	        }  
	        out.close();  
    	
    }  
}  