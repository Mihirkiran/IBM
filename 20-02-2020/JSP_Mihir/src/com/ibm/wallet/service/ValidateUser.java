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

@WebServlet("/ValidateUser")
public class ValidateUser extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		WalletDatabase wd = new WalletDatabase();
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		Customer cust = new Customer();
		cust.setUserID(userID);
		cust.setPassword(password);
		boolean b = wd.validate(cust);
		if(b) {
			HttpSession session = request.getSession();
			session.setAttribute("ID", userID);
			response.sendRedirect("dashboardjsp.jsp");
		}
		else {
			out.print("Invalid User ID or Password!!!<br>");
            request.getRequestDispatcher("LoginWallet.jsp").include(request, response);  
		}
	}

}
