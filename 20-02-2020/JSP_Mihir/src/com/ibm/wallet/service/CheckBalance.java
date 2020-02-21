package com.ibm.wallet.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.wallet.bean.Customer;
import com.ibm.wallet.dao.WalletDatabase;

@WebServlet("/CheckBalance")
public class CheckBalance extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession(false).getAttribute("ID") == null) {
			response.sendRedirect("index.jsp");
			//System.out.println("AA");
		} else {
			PrintWriter out = response.getWriter();
			WalletDatabase wd = new WalletDatabase();
			Customer cust = new Customer();
			HttpSession session = request.getSession();
			cust.setUserID((session.getAttribute("ID")).toString());
			int bal = wd.getBalance(cust);
			response.setContentType("text/html");
	        request.getRequestDispatcher("dashboardjsp.jsp").include(request, response);  
			out.print("Balance is: " + bal);
		}
	}
}
