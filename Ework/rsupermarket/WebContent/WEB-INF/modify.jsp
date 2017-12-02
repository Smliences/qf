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
<body>
<div class="menu">
	<form method="get" action="">
		åååç§°ï¼<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
		æ¯å¦ä»æ¬¾ï¼<select name="payStatus">
			<option value="">è¯·éæ©</option>
			<option value="1">å·²ä»æ¬¾</option>
			<option value="0">æªä»æ¬¾</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="ç»åæ¥è¯¢" class="button" />
	</form>
</div>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="æ·»å æ°æ®" class="input-button" onclick="location.href='modify.html'" /></em>
		<div class="title">è´¦åç®¡ç&gt;&gt;</div>
	</div>
	<form method="post">
		<div class="content">
			<table class="box">
				<tr>
					<td class="field">è´¦åç¼å·ï¼</td>
					<td><input type="text" name="billNum" class="text" /></td>
				</tr>
				<tr>
					<td class="field">äº¤æéé¢ï¼</td>
					<td><input type="text" name="money" class="text" /></td>
				</tr>
				<tr>
					<td class="field">ååæè¿°ï¼</td>
					<td><textarea name="discription"></textarea></td>
				</tr>
				<tr>
					<td class="field">æ¯å¦ä»æ¬¾ï¼</td>
					<td><select name="isPay">
						<option value="1">æ¯</option>
					</select></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="submit" value="ç¡®è®¤" class="input-button" />
			<input type="button" name="button" value="è¿å" class="input-button" onclick="history.back();" />
		</div>
	</form>
</div>
</body>
</html>
