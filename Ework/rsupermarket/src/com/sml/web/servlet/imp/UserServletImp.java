package com.sml.web.servlet.imp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sml.web.dao.UserDao;
import com.sml.web.dao.imp.UserDaoImp;
import com.sml.web.pojo.PageBean;
import com.sml.web.pojo.User;
import com.sml.web.servlet.UserServlet;
//git
/**
 * Servlet implementation class UserServletImp
 */
@WebServlet("/UserServlet")
public class UserServletImp extends HttpServlet implements UserServlet{
    private UserDao dao = new UserDaoImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		System.out.println(method);
		switch (method) {
		case "login":
			login(request,response);
			break;
		case "list":
			quertList(request, response);
		case "top":
			top(request, response);
		case "left":
			left(request, response);
		case "toAdd":
			toAdd(request, response);
		case "add":
			Add(request, response);
		case "toUpdate":
			toUpdate(request, response);
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void quertList(HttpServletRequest req, HttpServletResponse res) {
		if (req.getParameter("page").equals(null)) {
			List<User> userList = dao.queryUserList();
			req.setAttribute("userList", userList);

			try {
				req.getRequestDispatcher("WEB-INF/userAdmin.jsp").forward(req, res);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}

		} else {
			
			int pageNum = Integer.valueOf(req.getParameter("page"));
			int totalCount = dao.queryUserCount();

			PageBean pageBean = new PageBean(totalCount, 5, pageNum - 1);
			List<User> userList = dao.queryPageBeanlist(pageBean);

			System.out.println(pageBean);
			req.setAttribute("pageBean", pageBean);
			req.setAttribute("userList", userList);

			try {
				req.getRequestDispatcher("WEB-INF/userAdmin.jsp").forward(req, res);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void insert(HttpServletRequest req, HttpServletResponse res) {
		
	}

	@Override
	public void delete(HttpServletRequest req, HttpServletResponse res) {
		
	}

	@Override
	public void update(HttpServletRequest req, HttpServletResponse res) {
		
	}

	@Override
	public void login(HttpServletRequest req, HttpServletResponse res) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String existPassword = dao.queryByUsername(username);
		
		if ((password.equals(existPassword)) && (existPassword != null)) {
			req.getSession().setAttribute("username", username);
			try {
				req.getRequestDispatcher("WEB-INF/admin_index.jsp").forward(req, res);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				res.sendRedirect("login.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void list(HttpServletRequest req, HttpServletResponse res) {
		if (req.getParameter("page").equals(null)) {
			List<User> userList = dao.queryUserList();
			req.setAttribute("userList", userList);

			try {
				req.getRequestDispatcher("WEB-INF/userAdmin.jsp").forward(req, res);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}

		} else {

			int pageNum = Integer.valueOf(req.getParameter("page"));
			int totalCount = dao.queryUserCount();

			PageBean pageBean = new PageBean(totalCount, 5, pageNum - 1);
			List<User> userList = dao.queryPageBeanlist(pageBean);

			System.out.println(pageBean);
			req.setAttribute("pageBean", pageBean);
			req.setAttribute("userList", userList);

			try {
				req.getRequestDispatcher("WEB-INF/userAdmin.jsp").forward(req, res);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void left(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.getRequestDispatcher("WEB-INF/admin_left.jsp").forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void top(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.getRequestDispatcher("WEB-INF/admin_top.jsp").forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void toAdd(HttpServletRequest req, HttpServletResponse res) {
		try {
				req.getRequestDispatcher("WEB-INF/userAdd.jsp").forward(req, res);

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Add(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		Enumeration<String> eum = req.getAttributeNames();
		User user = new User();

		if (req.getParameter("password").equals(req.getParameter("password1"))) {
			user.setUsername(req.getParameter("username"));
			user.setAge(Integer.valueOf(req.getParameter("age")));
			user.setAddress(req.getParameter("address"));
			user.setPassword(req.getParameter("password"));
			
			if (req.getParameter("sex").equals("0")) {
				user.setSex("男");
			} else {
				user.setSex("女");
			}
			if (req.getParameter("job").equals("0")) {
				user.setJob("普通用户");
			} else {
				user.setJob("经理");
			}
			
			user.setPhone(req.getParameter("phone"));
			dao.insert(user);
		}
		try {
			req.getRequestDispatcher("UserServlet?method=list&page=1").forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void toUpdate(HttpServletRequest req, HttpServletResponse res) {
		try {
			System.out.println(req.getParameter("method"));
			System.out.println(req.getParameter("uid"));
			int uid = Integer.valueOf(req.getParameter("uid"));
			User user = dao.query(uid);
			System.out.println(user);
			req.setAttribute("user", user);
			req.getRequestDispatcher("WEB-INF/userAdd.jsp").forward(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	


}
