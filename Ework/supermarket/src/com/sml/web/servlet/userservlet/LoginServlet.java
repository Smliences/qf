package com.sml.web.servlet.userservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sml.web.dao.UserDao;
import com.sml.web.dao.imp.UserDaoImp;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private UserDao dao = new UserDaoImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String existPassword = dao.queryByUsername(username);
		
		if ((password.equals(existPassword)) && (existPassword != null)) {
			request.getSession().setAttribute("username", username);
//			response.sendRedirect("WEB-INF/admin_index.html");
			request.getRequestDispatcher("WEB-INF/admin_index.jsp").forward(request, response);
		} else {
			response.sendRedirect("login.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
