package com.sml.web.servlet.userservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sml.web.dao.UserDao;
import com.sml.web.dao.imp.UserDaoImp;
import com.sml.web.pojo.PageBean;
import com.sml.web.pojo.User;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
     private UserDao dao = new UserDaoImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("page").equals(null)) {
			List<User> userList = dao.queryUserList();
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("WEB-INF/userAdmin.jsp").forward(request, response);
		} else {
			int pageNum = Integer.valueOf(request.getParameter("page"));
			int totalCount = dao.queryUserCount();

			PageBean pageBean = new PageBean(totalCount, 5, pageNum - 1);
			List<User> userList = dao.queryPageBeanlist(pageBean);
			System.out.println(pageBean);
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("WEB-INF/userAdmin.jsp").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
