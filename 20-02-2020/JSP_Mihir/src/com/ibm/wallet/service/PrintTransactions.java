package com.ibm.wallet.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.wallet.bean.Customer;
import com.ibm.wallet.dao.WalletDatabase;

@WebServlet("/PrintTransactions")
public class PrintTransactions extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		WalletDatabase wd = new WalletDatabase();
		Customer cust = new Customer();
		if (request.getSession(false).getAttribute("ID") == null) {
			response.sendRedirect("index.jsp");
			//System.out.println("AA");
		} else {
			HttpSession session = request.getSession();
			cust.setUserID((session.getAttribute("ID")).toString());
			ResultSet rs = wd.printTransaction((session.getAttribute("ID")).toString());
	        request.getRequestDispatcher("dashboardjsp.jsp").include(request, response);  
	
			try {
				if(rs.next()) {
					out.println("From: " + rs.getString("fromUserID") + " "
							+ "To: " + rs.getString("toUserID") + " "
									+ "Amount: " + rs.getInt("amount") + " "
											+ "Time: " + rs.getString("transactionTime") + "<br>");
					while(rs.next()) {
						out.println("From: " + rs.getString("fromUserID") + " "
								+ "To: " + rs.getString("toUserID") + " "
										+ "Amount: " + rs.getInt("amount") + " "
												+ "Time: " + rs.getString("transactionTime") + "<br>");
					}
				}
				else {
					out.println("No transaction history");
				}
			} catch (SQLException e) {
				out.println("Error!!!");
			}
		}
	}
}


