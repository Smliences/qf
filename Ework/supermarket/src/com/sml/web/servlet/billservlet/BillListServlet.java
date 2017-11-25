package com.sml.web.servlet.billservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sml.web.dao.BillDao;
import com.sml.web.dao.imp.BillDaoImp;
import com.sml.web.pojo.Bill;

/**
 * Servlet implementation class ToBillListServlet
 */
@WebServlet("/BillListServlet")
public class BillListServlet extends HttpServlet {
     private BillDao dao = new BillDaoImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Bill> billList = dao.queryBillList();
		request.setAttribute("billList", billList);
		request.setAttribute("test", "test");
		request.getSession().setAttribute("test1", "test1");
		request.getRequestDispatcher("WEB-INF/admin_bill_list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
