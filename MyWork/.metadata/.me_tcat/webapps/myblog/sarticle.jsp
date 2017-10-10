<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Smliences</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="${pageContext.request.contextPath }/js/jquery-1.4.2.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <style type="text/css">
  	*{
  		margin:0px; 
  		padding:0px;
  	}
  	body>header{
  		position: fixed;
    	height: 100%;
  	}
  	div{
  		display:block;
  	}
  	#div-left{
  		width:600px;
  		height:100%;
  		float:left;
  		background:url(images/1.jpg) no-repeat;
  		background-size:cover;
  	}
  	#div-left #img{
  		width:40%;
  		height:100%
  		background-image: no-repeat;
  	}
  	#div-left #message{
  	padding-top:10px;
  	font-size: 18px;
  	}
  	#div-left .text{
  		padding-top:100px;
  		text-align:center;
  		margin:0 auto;
  		width: 100%;
  		height:86.75%;
        left:0; 
        font-size:20px;
        background-color: rgba(0,0,0,0.3); 
        color:  rgba(255, 255, 255, 0.8);
        
  	}
  	a{
  		text-decoration:none;
  	}
  	#div-left a{
  		color:rgba(255, 255, 255, 0.8);
  	}
  	body {
  		background-color:  #f3f5f8;
  	}
  	
  	#div-right{
  		float:left;
  		padding-top: 100px;
  		padding-left:650px;
    	background-color: #f3f5f8;
    	height: 100%;
    	width: 50%;
  	}
  	
  	#div-right span{
  		padding-left:730px;
  		margin:0 auto;
  		color:black;
  	}
  	#div-right a{
  		padding-left:100px;
  	}
  	#div-right p{
  		padding-left:100px;
  		width:60%;
  		height:66px;
  		line-height:22px;
  		o
  		text-overflow:clip;
  		display:block;
  	}
  	
  	#div-right .time{
  		padding-left:100px;
  		font-size: 10px;
  		color:grey;
  	} 
  	
  	#div-right>article{
  		margin-bottom:30px;
  	}
  	
  	#div-rigth>h2{
  		margin-bottom:60px;
  	}
  	
  	.fixed_img{
    	bottom:450px;
    	display:block;
    	position:fixed;
    	right:10px;
    	height:60px;
    	width:60px;
	}
	.fixed {
		bottom:450px;
    	display:block;
    	position:fixed;
    	right:10px;
    	height:60px;
    	width:60px;
	}
	
	.fixed #lmessage{
		padding-left: 25px;
		text-align:center;
	}
	.msg{
   		margin-left: 77px;
		margin-top: 24px;
		text-align: start;
	}
	.msg .cname{
		margin-top:10px;
	}
	.msg .cname p{
		font-weight:600;
		font-size:15px;
	}
	.msg .ccomment p{
	margin-top: 6px;
	font-size:15px;
	}
	#form{
		border: 1px solid #eee;
		color: #8a8a8a;
		top:1px;
   		display:block;
   		position:fixed;
  		right:0px;
  		height:320px;
    	width: 300px;
   		background-color: rgba(253, 253, 253, 0.95);
    	padding: 1.5em 1.25em 1.85em;
    	font: inherit;
	}
	#form div{
	
		margin-top:20px;
	}
	#form input{
    	width: 125px;
    	height: 28px
	}
	#lslj{
		margin-buttom:20px;
	}
	
	#form textarea{
		width:268px;
		height:150px;
	}
	#ne{
		display:block;
	}
	#form-name{
		float:left;
	}
	#form-email{
		float: right;
		margin-left:50px;
	}
	#form-button input{
		background-color: #fff;
		margin-top: 15px;
		width:300px;
	}
  </style>
  <body >
  		<header>
  		<div id="div-left" >
  			<div class="text">
  				<div>
  			<hgroup>
  				<span id="blog"></span><a href="">博客</a><br>
  				<span>smliences</span>
  			</hgroup>
  				<div id="message">
  				<p id="pmessage">
  					我是一名大三的学生，正在学习javaweb后台，为自己写了一个简单的博客，页面很烂,我也觉得。以后会慢慢变好。
  				</p>
  				</div>
  				<c:forEach items="${list }" var="l">
  				<div class="msg">
  					<div class="cname"><p>${l.name }</p></div>
  					<div class="ccomment"><p>${l.lmessage}</p></div>
  				</div>
  				</c:forEach>
  			</div>
  			</div>
  		</div>
  		</header>
		
		<div id="div-right">
  			<article>
  				<header>
  					<h2 ><a href="">${article.title }</a></h2><br>
  					<div class="article">
  					<p>${article.content}</p><br>
  					<span class="time">
  					<time datetime="2017-03-23">${article.wtime }</time>
  					</span>
  					</div>
  				</header>
  			</article><br><br><br>
		</div>
  </body>
  <script type="text/javascript">
  			$(function(){
			
			$.get('${pageContext.request.contextPath}/comment_findAll.action');
		});
	
		$(function(){
			function change(){
			var i=parseInt(Math.random()*(4)+1); 
			$('#div-left').css("background","url(images/"+i+".jpg) no-repeat");
			$('#div-left').css("background-size","cover");
			}
			t = setInterval(change,20000);
		});;
  	 	
  </script>
</html>