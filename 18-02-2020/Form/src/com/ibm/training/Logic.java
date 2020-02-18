package com.ibm.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logic")
public class Logic extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String user = request.getParameter("userName");
		
		String user1 = request.getParameter("password");
		
		String user2 = request.getParameter("gender");
		
		String user3 = request.getParameter("birthday");
		
		String user4 = request.getParameter("email");
		
		String[] user5 = request.getParameterValues("lang");
		
		out.println("Name: " + user + "<br>");
		out.println("Password: " + user1 + "<br>");
		out.println("Gender: " + user2 + "<br>");
		out.println("Birthday: " + user3 + "<br>");
		out.println("E-mail: " + user4 + "<br>");
		out.println("Language Preferences:<br>"); 
		for(int i = 0; i < user5.length; i++) {
			out.println(user5[i] + "<br>");
		}
	}
}
