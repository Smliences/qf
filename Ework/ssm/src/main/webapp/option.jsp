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

		<form  action="updateCount.action">
			<c:forEach items="${optionList }" var="option">
			<input type="radio" name="o_id" value="${option.o_id }" />${option.content}<br/>
			<input type="hidden" name="v_id" value="${option.v_id }"/>
			</c:forEach>
			<input type="submit" value="提交 " />
		</form>
	</body>

</html>