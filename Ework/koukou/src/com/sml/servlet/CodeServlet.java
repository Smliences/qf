package com.sml.servlet;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sml.util.VerifyCode;

/**
 * Servlet implementation class CodeServlet
 */
@WebServlet("/CodeServlet")
public class CodeServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VerifyCode verifyCode = new VerifyCode();
        BufferedImage bi = verifyCode.getImage();
        String text = verifyCode.getText();
        System.out.println(text);
        String name = UUID.randomUUID().toString().replace("-", "").substring(0, 4);
        try {
			VerifyCode.output(bi, new FileOutputStream("D:\\git\\qf\\Ework\\koukou\\WebContent\\code\\" + name + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        String str = name + "-" + text;
        System.out.println(str);
        try {
			response.getWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
