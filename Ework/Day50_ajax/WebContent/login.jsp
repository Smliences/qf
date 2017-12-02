<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
		<script>
			window.onload = function() {
				document.getElementById("username").onblur = function() {
						var xhr = new XMLHttpRequest();
						xhr.open("POST", "UserServlet", true);
						var username = document.getElementById("username").value;
						
						var url = "method=login&username=" + username;
						xhr.setRequestHeader("Content-type",
						"application/x-www-form-urlencoded");

						xhr.send(url);
						xhr.onreadystatechange = function() {
							if(xhr.readyState == 4 && xhr.status == 200)
								var message = document.getElementById("message").innerHTML = xhr.responseText;
						}
				}
			}
		</script>
	</head>

	<body>
		<form method="post" action="">
			<div id="message"></div>
			用户:<input type="text" name="username" id="username"><br> 密码:
			<input type="password" name="password" id="password"><br>
			<input type="submit" value="登录">
		</form>
	</body>

</html>