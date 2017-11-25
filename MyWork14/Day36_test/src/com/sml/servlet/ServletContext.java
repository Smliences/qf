package com.sml.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContext extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		javax.servlet.ServletContext context = this.getServletContext();
		javax.servlet.ServletContext servletContext = this.getServletConfig().getServletContext();
		context.getContextPath();
		String initParameter = context.getInitParameter("");
		Enumeration<String> initParameterNames = context.getInitParameterNames();
		context.setAttribute("1", 2);
	}
}
