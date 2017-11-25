package com.sml.contact.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sml.contact.dao.ContactDao;
import com.sml.contact.dao.impl.ContactDaoImpl;
import com.sml.contact.entity.Contact;

public class ListContactServlet extends HttpServlet {
	ContactDao dao = new ContactDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Contact> contactList = dao.findAll();

		PrintWriter writer = response.getWriter();
		
		String html = "";
		
		html += "<!doctype html>";
		html += "<html>";
		html += "<head>";
		html += "<title>��ʾ������ϵ��</title>";
		html += "</head>";
		html += "<body>";
		
		html += "<center><h3>������ϵ��</h3></center>";
		html += "<table border = '1' align = 'center' width='800px'";
		html += "<tr>";
		html += "<th>���</th><th>����</th><th>�Ա�</th><th>����</th><th>����</th>"
				+ "<th>QQ</th><th>�绰</th><th>����</th>";
		html += "</tr>";
		
		if (contactList != null) {
			for (Contact contact : contactList) {
				html += "<tr>";
				html += "<td>" + contact.getId() + "</td>";
				html += "<td>" + contact.getName() + "</td>";
				html += "<td>" + contact.getGender() + "</td>";
				html += "<td>" + contact.getAge() + "</td>";
				html += "<td>" + contact.getEmail() + "</td>";
				html += "<td>" + contact.getQq() + "</td>";
				html += "<td>" + contact.getPhone() + "</td>";
				html += "<td><a href='"+ request.getContextPath() 
						+"/QueryContactServlet?id="+ contact.getId() + "'>�޸�</a>";
				html += "&nbsp;<a href='"+ request.getContextPath() 
						+"/DeleteContactServlet?id="+ contact.getId() + "'>ɾ��</a></td>";
				/**
				 * <td><a href="/Day38/ContactSystemWeb/DeleteContactServlet?id=001">ɾ��</a></td>
				 * "<td><a href='" + req.getContextPath + "/DeleteContactServlet?id=" + contact.getID + "' >ɾ�� </a><td>
				 */
				html += "</tr>";
			}
		}
		
		html += "</table>";
		html += "<center><a href = '" + request.getContextPath() + "/addContact.html'>�����ϵ��</a></center>";
		html += "</body>";
		html += "</html>";
		
		writer.write(html);
}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
