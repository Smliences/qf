package com.sml.web.baseinterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BaseServlet<E> {
	public void queryList(HttpServletRequest req, HttpServletResponse res);
	public void insert(HttpServletRequest req, HttpServletResponse res);
	public void delete(HttpServletRequest req, HttpServletResponse res);
	public void queryById(HttpServletRequest req, HttpServletResponse res);
	public void update(HttpServletRequest req, HttpServletResponse res);
}