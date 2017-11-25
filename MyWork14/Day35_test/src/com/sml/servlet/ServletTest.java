package com.sml.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ServletConfig config = this.getServletConfig();
		String aaa = config.getInitParameter("AAA");
		Enumeration<String> initNames = config.getInitParameterNames();
		response.getWriter().write(aaa);
//		response.sendRedirect("http://www.baidu.com");
		request.getRequestDispatcher("http://www.baidu.com").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
