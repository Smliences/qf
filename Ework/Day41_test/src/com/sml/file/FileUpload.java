package com.sml.file;

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

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(100*1024);
		File file = new File("D:/test");
		if (!file.exists()) 
			file.mkdirs();
		factory.setRepository(file);

		ServletFileUpload fileupload = new ServletFileUpload(factory);
		fileupload.setFileSizeMax(10*1024*1024);
		fileupload.setSizeMax(50*1024*1024);

		try {
			List<FileItem> fileItems = fileupload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				if (fileItem.getName() != null && "".equals(fileItem.getName())) {
					String uuid = UUID.randomUUID().toString().replaceAll("-", "");
					fileItem.write(new File("D:/test/" + uuid + fileItem.getName()));
					fileItem.getFieldName();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
