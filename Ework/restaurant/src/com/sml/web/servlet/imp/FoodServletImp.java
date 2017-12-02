package com.sml.web.servlet.imp;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSON;
import com.sml.web.dao.FoodDao;
import com.sml.web.dao.imp.FoodDaoImp;
import com.sml.web.pojo.Cuisine;
import com.sml.web.pojo.Food;
import com.sml.web.servlet.FoodServlet;

/**
 * Servlet implementation class FoodServletImp
 */
@WebServlet("/detail/FoodServlet")
public class FoodServletImp extends HttpServlet implements FoodServlet{
	private FoodDao dao = new FoodDaoImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		switch (method) {
		case "insert":
			insert(request, response);
			break;
		case "list":
			queryList(request, response);
			break;
		case "toAdd":
			toAdd(request, response);
			break;
		case "toUpdate":
			toUpdate(request, response);
			break;
		case "getCuisine":
			getCuisine(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		case "update":
			update(request, response);
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
		List<Food> foodList = dao.queryList();
		req.setAttribute("foodList", foodList);
		try {
			req.getRequestDispatcher("foodList.jsp").forward(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void insert(HttpServletRequest req, HttpServletResponse res) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(100 * 1024);
		File temp = new File("D:/test/uploat");

		if (!temp.exists()) {
			temp.mkdirs();
		} 
		factory.setRepository(temp);

		ServletFileUpload fileupload = new ServletFileUpload(factory);
		fileupload.setFileSizeMax(10 * 1024 * 1024);
		fileupload.setFileSizeMax(50 * 1024 * 1024);
		
		try {
			List<FileItem> fileItems = fileupload.parseRequest(req);
			Food food = new Food();
			for (FileItem fileItem : fileItems) {
				String filename = fileItem.getName();
				if (filename != null && !"".equals(filename)) {
					System.out.println(fileItem.getName());
					
					String uuid = UUID.randomUUID().toString().replaceAll("-", "");
					String path = req.getServletContext().getRealPath("/upload");

					System.out.println(path);
					food.setF_img_url(path);
					File newFile = new File(temp + "/" + uuid + fileItem.getName());

					fileItem.write(newFile);
				} else {
					if (fileItem.getFieldName().equals("f_cid")) {
						food.setF_cid(fileItem.getString("utf-8"));
					}	
					if (fileItem.getFieldName().equals("f_name")) {
						food.setF_name(fileItem.getString("utf-8"));
					}	
					if (fileItem.getFieldName().equals("f_price")) {
						food.setF_price(fileItem.getString("utf-8"));
					}	
					if (fileItem.getFieldName().equals("f_vprice")) {
						food.setF_vprice(fileItem.getString("utf-8"));
					}
					if (fileItem.getFieldName().equals("f_desc")) {
						food.setF_desc(fileItem.getString("utf-8"));
					}
				}
			}
			System.out.println(food);
			dao.insert(food);
			
			req.getRequestDispatcher("FoodServlet?method=list").forward(req, res);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void delete(HttpServletRequest req, HttpServletResponse res) {
		Integer f_id = Integer.valueOf(req.getParameter("f_id"));
		dao.deleteById(f_id);
		try {
			req.getRequestDispatcher("FoodServlet?method=list").forward(req, res);
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
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(100 * 1024);
		File temp = new File("D:/test/uploat");

		if (!temp.exists()) {
			temp.mkdirs();
		} 
		factory.setRepository(temp);

		ServletFileUpload fileupload = new ServletFileUpload(factory);
		fileupload.setFileSizeMax(10 * 1024 * 1024);
		fileupload.setFileSizeMax(50 * 1024 * 1024);
		
		try {
			List<FileItem> fileItems = fileupload.parseRequest(req);
			Food food = new Food();
			for (FileItem fileItem : fileItems) {
				String filename = fileItem.getName();
				if (filename != null && !"".equals(filename)) {
					System.out.println(fileItem.getName());
					
					String uuid = UUID.randomUUID().toString().replaceAll("-", "");
					String path = req.getServletContext().getRealPath("/upload");

					System.out.println(path);
					food.setF_img_url(path);
					File newFile = new File(temp + "/" + uuid + fileItem.getName());

					fileItem.write(newFile);
				} else {
					if (fileItem.getFieldName().equals("f_cid")) {
						food.setF_cid(fileItem.getString("utf-8"));
					}	
					if (fileItem.getFieldName().equals("f_name")) {
						food.setF_name(fileItem.getString("utf-8"));
					}	
					if (fileItem.getFieldName().equals("f_price")) {
						food.setF_price(fileItem.getString("utf-8"));
					}	
					if (fileItem.getFieldName().equals("f_vprice")) {
						food.setF_vprice(fileItem.getString("utf-8"));
					}
					if (fileItem.getFieldName().equals("f_desc")) {
						food.setF_desc(fileItem.getString("utf-8"));
					}
				}
			}
			System.out.println(food);
			dao.update(food);
			
			req.getRequestDispatcher("FoodServlet?method=list").forward(req, res);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void toAdd(HttpServletRequest req, HttpServletResponse res) {
		try {
			res.sendRedirect("saveFood.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void toUpdate(HttpServletRequest req, HttpServletResponse res) {
		Integer f_id = Integer.valueOf(req.getParameter("f_id"));
		Food food = dao.queryById(f_id);
		req.setAttribute("food", food);
		try {
			req.getRequestDispatcher("updateFood.jsp").forward(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getCuisine(HttpServletRequest req, HttpServletResponse res) {
		List<Cuisine> cuisineList = dao.queryCuisineList();
		Object json = JSON.toJSON(cuisineList);
		System.out.println(json);
		try {
			res.getWriter().println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
