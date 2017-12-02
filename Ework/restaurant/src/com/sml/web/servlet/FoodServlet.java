package com.sml.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sml.web.baseinterface.BaseServlet;
import com.sml.web.pojo.Food;

public interface FoodServlet extends BaseServlet<Food>{
	public void toAdd(HttpServletRequest req, HttpServletResponse res);
	public void toUpdate(HttpServletRequest req, HttpServletResponse res);
	public void getCuisine(HttpServletRequest req, HttpServletResponse res);
}
