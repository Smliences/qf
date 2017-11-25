<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0" align="center" width="800px">
		<tr><th>名字</th><th>操作</th></tr>
		<c:forEach items="${maps }" var="map">
			<tr><td>${map.key }</td><td><a href="${pageContext.request.contextPath }/jsp/DownServlet?file=${map.value}">下载</a>&nbsp;<a href="">删除</a></td></tr>
		</c:forEach>
	</table>
</body>
</html>