package com.sml.contact.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sml.contact.dao.ContactDao;
import com.sml.contact.dao.impl.ContactDaoImpl;

public class DeleteContactServlet extends HttpServlet {
	ContactDao dao = new ContactDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		dao.deleteContactById(id);
		response.sendRedirect(request.getContextPath() + "/ListContactServlet");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
