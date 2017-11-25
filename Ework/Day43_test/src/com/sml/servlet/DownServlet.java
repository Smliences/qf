package com.sml.servlet;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DownServlet
 */
@WebServlet("/jsp/DownServlet")
public class DownServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("file");
       
		File file = new File(url);
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=" +URLEncoder.encode(file.getName(), "utf-8"));
		ServletOutputStream out = response.getOutputStream(); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
