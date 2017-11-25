package com.sml.list.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sml.list.dao.UserDao;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/list/ListServlet")
public class ListServlet extends HttpServlet {
	private UserDao dao = new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Map<String, String> list = dao.findList();
		 
		 request.setAttribute("lists",list);
		 request.getRequestDispatcher("/list/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
