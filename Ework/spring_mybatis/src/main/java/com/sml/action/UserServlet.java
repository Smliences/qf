package com.sml.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sml.pojo.User;
import com.sml.service.UserService;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService userService = (UserService) req.getSession().getServletContext().getAttribute("userService");
		List<User> userList = userService.selectAll();
		System.out.println(userList);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
