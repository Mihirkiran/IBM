package com.ibm.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter();
		
		PrintWriter out = response.getWriter();
		out.println("Servlet called!!!");
		out.println("Application served at: " + request.getServletPath());
	}
}
