<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.sml.contact.entity.Contact"%>
<%@page import="com.sml.contact.dao.impl.ContactDaoImpl"%>
<%@page import="com.sml.contact.dao.ContactDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	errorPage="" 
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <table border = "1" width = "800px">
  	<tr>
  		<th>编号</th><th>姓名</th><th>性别</th><th>年龄</th><th>邮箱</th>
		<th>QQ</th><th>电话</th><th>功能</th>
  	</tr>
  <%
  	ContactDao dao = new ContactDaoImpl();
  	List<Contact> list = dao.findAll();
	
  	for (Contact contact : list) {
  		out.println("<tr>" + 
  				"<td>" + contact.getId() + "</td>" + 
  				"<td>" + contact.getName() + "</td>" +
  				"<td>" + contact.getGender() + "</td>" +
  				"<td>" + contact.getAge() + "</td>" +
  				"<td>" + contact.getEmail() + "</td>" +
  				"<td>" + contact.getQq() + "</td>" +
  				"<td>" + contact.getPhone() + "</td>" +
  				 "</tr>"
  				);
  	}
  %>
	</table>

  </body>
</html>
