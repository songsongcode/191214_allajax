<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
</head>
<body>
	<form action="UserServlet"	method="post">
	<input type="hidden" name="action" value="register"/>
	
		姓名：<input type="text" value="" name="uname" placeholder="请输入注册姓名" /><span></span><br />
		性别:<input type="radio"checked="checked" value="男" name="usex" />男 
			<input type="radio"value="女" name="usex" />女<br /> 
		年龄：<input type="text" value="" name="uage" placeholder="请输入年龄" /><br /> 
		电话：<input type="text" value="" name="uphone" placeholder="请输入电话" /><br />
		<input type="submit" value="注册"/><a href="index.html"><input type="button" value="返回" /></a>
	</form>
</body>
</html>