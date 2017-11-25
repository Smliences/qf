package com.sml.web.servlet.providerservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sml.web.dao.ProviderDao;
import com.sml.web.dao.imp.ProviderDaoImp;
import com.sml.web.pojo.Provider;


/**
 * Servlet implementation class ProviderListServlet
 */
@WebServlet("/ProviderListServlet")
public class ProviderListServlet extends HttpServlet {
    private ProviderDao dao = new ProviderDaoImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Provider> providerList = dao.queryProviderList();
		request.setAttribute("providerList", providerList);
		request.getRequestDispatcher("WEB-INF/providerAdmin.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
