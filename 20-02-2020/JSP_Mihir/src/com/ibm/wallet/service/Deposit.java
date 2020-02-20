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

@WebServlet("/Deposit")
public class Deposit extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		WalletDatabase wd = new WalletDatabase();
		Customer cust = new Customer();
		HttpSession session = request.getSession();
		cust.setUserID((session.getAttribute("ID")).toString());
		boolean b = wd.deposit(Integer.parseInt(request.getParameter("amount")), cust);
        request.getRequestDispatcher("dashboardjsp.jsp").include(request, response);  
		if(b)
			out.print("Deposited");
		else
			out.print("Error!!!");
	}
}


