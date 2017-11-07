<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<link style="" type="text/css" href="">
<style type="text/css">
	h2{
		width:200px;
		heigth:300px;
		border:1px solid red;
		
	}
</style>
</head>

<body>
	<p>1</p>
	<h1>2</h1>
	<h2>3</h2>
	<h3>4</h3>
	<a href="" target="_self"></a>
	<ul>
		<li></li>
		<li></li>
	</ul>
</body>
</html>
