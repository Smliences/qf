package com.sml.web.servlet.userservlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sml.web.dao.UserDao;
import com.sml.web.dao.imp.UserDaoImp;
import com.sml.web.pojo.User;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    private UserDao dao = new UserDaoImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Enumeration<String> eum = request.getAttributeNames();
		User user = new User();

		if (request.getParameter("password").equals(request.getParameter("password1"))) {
			user.setUsername(request.getParameter("username"));
			user.setAge(Integer.valueOf(request.getParameter("age")));
			user.setAddress(request.getParameter("address"));
			user.setPassword(request.getParameter("password"));
			if (request.getParameter("sex").equals("0")) {
				user.setSex("女");
			} else {
				user.setSex("男");
			}
			if (request.getParameter("job").equals("0")) {
				user.setJob("普通用户");
			} else {
				user.setJob("经理");
			}
			user.setSex(request.getParameter("sex"));
			user.setPhone(request.getParameter("phone"));
		}
		dao.insert(user);
		request.getRequestDispatcher("UserListServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
