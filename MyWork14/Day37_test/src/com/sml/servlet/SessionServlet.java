package com.sml.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(60*60);
		System.out.println("SessionID:" + session.getId());
		Cookie c = new Cookie("JESSION", session.getId());
		c.setMaxAge(60*60);
		resp.addCookie(c);
		session.setAttribute("name", "sml");
	}
}
