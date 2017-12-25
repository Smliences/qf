<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<c:forEach items="${optionList }" var="option">
			${option.content } ${option.count }票
		</c:forEach>
		<a href="index.action">返回首页</a>
	</body>
</html>
