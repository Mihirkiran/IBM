package com.ibm.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test")
public class login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("userName").equals("mihir") && request.getParameter("password").equals("mihir")) {
			HttpSession session = request.getSession();
//			HttpSession session1 = request.getSession();
			session.setAttribute("userName", request.getParameter("userName"));
			session.setAttribute("password", request.getParameter("password"));
			response.sendRedirect("logout.html");
		}
		
		PrintWriter out = response.getWriter();
		
//		out.println("Welcome " + request.getParameter("userName"));
//		out.println("UserName in session : " + request.getSession().getAttribute("userName"));
			
	}

}
