package com.ibm.wallet.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.wallet.bean.Customer;
import com.ibm.wallet.dao.WalletDatabase;

@WebServlet("/FundTransfer")
public class FundTransfer extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		WalletDatabase wd = new WalletDatabase();
		Customer cust = new Customer();
		HttpSession session = request.getSession();
		cust.setUserID((session.getAttribute("ID")).toString());
		int amt = Integer.parseInt(request.getParameter("amount"));
		cust.setUserID((session.getAttribute("ID")).toString());
		Customer custRecieve = new Customer();
		custRecieve.setUserID(request.getParameter("userID"));
		String pattern = "MM/dd/yyyy HH:mm:ss";

		DateFormat df = new SimpleDateFormat(pattern);

		Date today = Calendar.getInstance().getTime();        

		String todayAsString = df.format(today);
		response.setContentType("text/html");

        request.getRequestDispatcher("dashboardjsp.jsp").include(request, response);  
        
		boolean b = wd.fundTransfer(cust, custRecieve, amt, todayAsString);
		if(b)
			out.print("Transferred");
		else
			out.print("Error!!!");
	}
}


