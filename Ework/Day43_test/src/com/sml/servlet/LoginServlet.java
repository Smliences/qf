package com.sml.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sml.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private UserDao dao = new UserDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String existUserName = request.getParameter("username");
		String existPassWord = request.getParameter("password");
		boolean flag = dao.findPasswordByUser(existUserName, existPassWord);

		if (flag) {
			request.getSession().setAttribute("username", existUserName);

			Cookie userNameCookie = new Cookie("username", existUserName);
			Cookie passWordCookie = new Cookie("password", existPassWord);
			userNameCookie.setMaxAge(60*60*24);
			passWordCookie.setMaxAge(60*60*24);
			response.addCookie(userNameCookie);
			response.addCookie(passWordCookie);
			
			request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
