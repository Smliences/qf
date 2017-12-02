package com.sml.web.servlet;

import java.util.stream.BaseStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sml.web.baseinterface.BaseServlet;
import com.sml.web.pojo.User;

public interface UserServlet extends BaseServlet<User>{
	public void login(HttpServletRequest req, HttpServletResponse res);
	public void list(HttpServletRequest req, HttpServletResponse res);
	public void left(HttpServletRequest req, HttpServletResponse res);
	public void top(HttpServletRequest req, HttpServletResponse res);
	public void toAdd(HttpServletRequest req, HttpServletResponse res);
	public void Add(HttpServletRequest req, HttpServletResponse res);
	public void toUpdate(HttpServletRequest req, HttpServletResponse res);
}
