package com.sml.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
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

import com.sml.dao.UserDao;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/jsp/UploadServlet")
public class UploadServlet extends HttpServlet {
	private UserDao dao = new UserDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(100*1024);

		File file = new File("D:/test/jsp");
		if (!file.exists()) {
			file.mkdirs();
		}
		factory.setRepository(file);
		
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		fileUpload.setFileSizeMax(10 * 1024 * 1024);
		fileUpload.setSizeMax(50 * 1024 * 1024);
		
		List<FileItem> fileItems;
		try {
			fileItems = fileUpload.parseRequest(request);
			
			for (FileItem fileItem : fileItems) {
					String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);
					File f = new File("D:/test/jsp/" + uuid + fileItem.getName());

					fileItem.write(f);
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, String> map = dao.findList(file);
		request.setAttribute("maps", map);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
