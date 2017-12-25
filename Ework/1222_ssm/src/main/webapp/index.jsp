<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
	</head>

	<body>
		<ul>
		<c:forEach items="${voteList}" var="vote">
			<li>
				<a href="optionList.action?v_id=${vote.v_id }">${vote.title }</a> <a href="result.action?v_id=${vote.v_id }"> 查看结果</a>
			</li>
		</c:forEach>	
		</ul>
		<a href="add.action">新增投票</a>
	</body>

</html>