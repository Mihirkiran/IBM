package com.ibm.wallet.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.wallet.bean.Customer;
import com.ibm.wallet.dao.WalletDatabase;

@WebServlet("/RegisterUserSuccess")
public class RegisterUserSuccess extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		WalletDatabase wd = new WalletDatabase();
		Customer cust = new Customer();
		String password = request.getParameter("password");
		String userName = request.getParameter("password");
		String userID = request.getParameter("password");
		String phoneNumber = request.getParameter("password");
//		if(password.length() > 30 || userName.length() > 30 || userID.length() > 30 || phoneNumber.length() > 10) {
//			response.setContentType("text/html");
//			out.print("Error!!!<br>");
//	        request.getRequestDispatcher("Register.jsp").include(request, response);  
//		}
//		else {
			cust.setBalance(0);
			cust.setPassword(request.getParameter("password"));
			cust.setUserName(request.getParameter("userName"));
			cust.setUserID(request.getParameter("userID"));
			cust.setPhoneNumber(request.getParameter("phoneNumber"));
	        response.setContentType("text/html");
			if(wd.createAccount(cust)) {
				request.getRequestDispatcher("LoginWallet.jsp").include(request, response);  
		        out.print("Account Created!!!");
			}
		    else
				out.print("Error in creating the account!!!");
		
	}

}
