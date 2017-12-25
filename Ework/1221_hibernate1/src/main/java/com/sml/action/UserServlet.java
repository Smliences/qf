package com.sml.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sml.service.UserService;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private UserService userService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext webApp = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		userService = (UserService) webApp.getBean("userService");
		System.out.println(userService.getUserList());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
