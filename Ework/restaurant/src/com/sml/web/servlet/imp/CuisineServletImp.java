package com.sml.web.servlet.imp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sml.web.dao.CuisineDao;
import com.sml.web.dao.imp.CuisineDaoImp;
import com.sml.web.pojo.Cuisine;
import com.sml.web.servlet.CuisineServlet;

/**
 * Servlet implementation class CuisneServletImp
 */
@WebServlet("/detail/CuisineServlet")
public class CuisineServletImp extends HttpServlet implements CuisineServlet{
	private CuisineDao dao = new CuisineDaoImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		System.out.println(method);
		switch (method) {
		case "list":
			queryList(request, response);
			break;
		case "insert":
			insert(request, response);
			break;
		case "toAdd":
			toAdd(request, response);
			break;
		case "toUpdate":
			toUpdate(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void queryList(HttpServletRequest req, HttpServletResponse res) {
		List<Cuisine> cuisineList = dao.queryList();
		req.setAttribute("cuisineList", cuisineList);
		try {
			req.getRequestDispatcher("cuisineList.jsp").forward(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void insert(HttpServletRequest req, HttpServletResponse res) {
		if (req.getParameter("submit").equals("提交")) {
			Cuisine cuisine = new Cuisine();

//			cuisine.setC_id(Integer.valueOf(req.getParameter("c_id")));
			cuisine.setC_name(req.getParameter("c_name"));
			dao.insert(cuisine);

			try {
				req.getRequestDispatcher("CuisineServlet?method=list").forward(req, res);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Cuisine cuisine = new Cuisine();
			cuisine.setC_name(req.getParameter("c_name"));
			cuisine.setC_id(Integer.valueOf(req.getParameter("c_id")));
			dao.update(cuisine);
			try {
				req.getRequestDispatcher("CuisineServlet?method=list").forward(req, res);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

	@Override
	public void delete(HttpServletRequest req, HttpServletResponse res) {
		Integer c_id = Integer.valueOf(req.getParameter("c_id"));
		dao.deleteById(c_id);
		try {
			req.getRequestDispatcher("CuisineServlet?method=list").forward(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void queryById(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub

	}

	@Override
	public void toAdd(HttpServletRequest req, HttpServletResponse res) {
		try {
			res.sendRedirect("updateCuisine.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void toUpdate(HttpServletRequest req, HttpServletResponse res) {
		int c_id = Integer.valueOf(req.getParameter("c_id"));
		Cuisine cuisine = dao.queryById(c_id);
		req.setAttribute("cuisine", cuisine);
		try {
			req.getRequestDispatcher("updateCuisine.jsp").forward(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
