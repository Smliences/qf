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
<div class="main">
	<div class="optitle clearfix">
		<div class="title">ä¾åºåç®¡ç&gt;&gt;</div>
	</div>
	<form id="form1" name="form1" method="post" action="provider.do" onsubmit="return checkit();">
		<div class="content">
		<font color="red"></font>
<input name="flag" value="doAdd" type="hidden">
			<table class="box">

			<tbody><tr>
					<td class="field">ä¾åºåç¼å·ï¼</td>
					<td><input name="proId" id="textfield" class="text" type="text"> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">ä¾åºååç§°ï¼</td>
					<td><input name="proName" id="textfield2" value="" class="text" type="text"> <font color="red">*</font></td>

				</tr>
			<tr>
					<td class="field">ä¾åºåæè¿°ï¼</td>
					<td><textarea name="proDesc" id="textarea" cols="45" rows="5"></textarea></td>
				</tr>
				<tr>
					<td class="field">ä¾åºåèç³»ï¼</td>

					<td><input name="contact" id="textfield2" value="" class="text" type="text"></td>
				</tr>
				<tr>
					<td class="field">ä¾åºåçµè¯ï¼</td>
					<td><input name="phone" id="textfield2" value="" class="text" type="text"></td>
				</tr>
				<tr>
					<td class="field">ä¾åºåä¼ çï¼</td>

					<td><input name="fax" id="textfield2" value="" class="text" type="text"></td>
				</tr>
				<tr>
					<td class="field">ä¾åºåå°åï¼</td>
					<td><input name="address" id="textfield2" value="" class="text" type="text"></td>
				</tr>
			</tbody></table>
		</div>

		<div class="buttons">
			<input name="button" id="button" value="æäº¤" class="input-button" type="submit"> 
			<input name="button" id="button" onclick="window.location='provider.do';" value="è¿å" class="input-button" type="button"> 
		</div>
	</form>
</div>
</body>
</html>
