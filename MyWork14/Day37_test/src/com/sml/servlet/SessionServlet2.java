package com.sml.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null) {
			System.out.println("没有找到对应的Session");
			return;
		}
		session.invalidate();
		System.out.println("SessionID:" + session.getId());
		String name = (String) session.getAttribute("name");
		System.out.println(name);
	}

}
