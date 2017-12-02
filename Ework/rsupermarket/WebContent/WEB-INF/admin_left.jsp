<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body class="frame-bd">
<ul class="left-menu">
	<li><a href="BillListServlet" target="mainFrame"><img src="images/btn_bill.gif" /></a></li>
	<li><a href="ProviderListServlet" target="mainFrame"><img src="images/btn_suppliers.gif" /></a></li>
	<li><a href="UserServlet?method=list&page=1" target="mainFrame"><img src="images/btn_users.gif" /></a></li>
	<li><a href="#" onClick="javaScript:alert('è¿éå®ç°éåºæä½ï¼')"><img src="images/btn_exit.gif" /></a></li>
</ul>
</body>
</html>
