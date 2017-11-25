package com.sml.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResourceDemo extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = this.getServletContext().getRealPath("");
		InputStream in = this.getServletContext().getResourceAsStream("");
		
		Properties prop = new Properties();
		prop.load(in);
		String user = prop.getProperty("user");
		
		Cookie cookie = new Cookie("name", "1234");
		cookie.setPath("");
		response.addCookie(cookie);
		Cookie[] cookies = request.getCookies();
	}
}
