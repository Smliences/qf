package com.sml.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sml.mapper.UserMapper;
import com.sml.pojo.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNumStr = request.getParameter("pageNum");
		String pageSizeStr = request.getParameter("pageSize");
		int pageNum;
		int pageSize;
		
		if (pageNumStr == null || "".equals(pageNumStr)) {
			pageNum = 1;
		} else {
			pageNum = Integer.valueOf(pageNumStr);
		}
		
		if (pageSizeStr == null || "".equals(pageSizeStr)) {
			pageSize = 4;
		} else {
			pageSize = Integer.valueOf(pageSizeStr);
		}
		
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("mybatis_config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		PageHelper.startPage(pageNum, pageSize);
		List<User> userList = userMapper.selectAll();
		PageInfo<User> pageInfo = new PageInfo<User>(userList);
		System.out.println(userList);
		System.out.println(pageInfo);
		System.out.println(pageInfo.getList());
		request.setAttribute("page", pageInfo);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
