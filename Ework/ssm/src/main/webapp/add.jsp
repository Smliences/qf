<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

		<script>
			$(function() {
				var index = 0;
				$("#sub").hide()
				$("#add").click(function() {
					index++;
					$("#sub").show()

					$("#add").before($("<p>"+index+"<input name='options' type='text' /></p>"))
				})
			})
		</script>
	</head>

	<body>
		<form action="insert.action">
			请输入一个标题<input name="title" /><br/>

			<input type="button" value="新增一个新的选项" id="add" />
			<input type="submit" id="sub" />

		</form>

	</body>

</html>