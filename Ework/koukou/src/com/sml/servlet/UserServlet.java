package com.sml.servlet;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sml.util.VerifyCode;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5932155869960669507L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		switch (method) {
		case "regist":
			regist(response, request);
			break;
		case "checkName":
			checkName(request, response);
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void regist(HttpServletResponse res, HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password1");

		Cookie cookie = new Cookie(username, password);
		res.addCookie(cookie);
		
		try {
			res.sendRedirect("login.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void checkName(HttpServletRequest req, HttpServletResponse res) {
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		String username = req.getParameter("username");
		Cookie[] cookies = req.getCookies();
		int flag = 0;
		
		if (req.getCookies() == null) {
			flag = 0;
		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(username)) {
					flag = 1;
					return ;
				}
			}
		}
		if (flag == 0) {
			try {
				res.getWriter().write("用户名可以使用");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				res.getWriter().write("用户名已存在");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
//	public void code(HttpServletRequest req, HttpServletResponse res) {
//		 	VerifyCode verifyCode = new VerifyCode();
//	        BufferedImage bi = verifyCode.getImage();
//	        String text = verifyCode.getText();
//	        System.out.println(text);
//
//	        try {
//				VerifyCode.output(bi, new FileOutputStream("D:\\git\\qf\\Ework\\koukou\\WebContent\\code\\b.jpg"));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//	        
//	        try {
//				res.getWriter().print(text);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//	}
}
