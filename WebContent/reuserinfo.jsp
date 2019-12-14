<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改界面</title>
</head>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<body>
	<form action="UserServlet"	method="post">
	<input type="hidden" name="action" value="updateUser"/>
	<input type="hidden" name="uid" value=""/>
	
		姓名：<input type="text" value="" name="uname" placeholder="请输入注册姓名" /><span></span><br />
		性别:<input type="radio"checked="checked" value="男" name="usex" />男 
			<input type="radio"value="女" name="usex" />女<br /> 
		年龄：<input type="text" value="" name="uage" placeholder="请输入年龄" /><br /> 
		电话：<input type="text" value="" name="uphone" placeholder="请输入电话" /><br />
		<input type="submit" value="修改"/><a href="showusers.html"><input type="button" value="返回" /></a>
	</form>
	
<script type="text/javascript">
	$.ajaxSetup({
		"contentType":"application/www-form-urlencoded;charset=utf-8"
	});
	var uid=getUrlParam('uid');
	//ajax获取用户信息
	$.post("/Test1213/UserServlet?action=Modify&uid="+uid,{},function(user_str){
		var user = JSON.parse(user_str);//将JS字符串转换为JSON对象
		$("input[name='uid']").val(user.uid+"");
		$("input[name='uname']").val(user.uname+"");
		$("input[name='uage']").val(user.uage+"");
		$("input[name='uphone']").val(user.uphone+"");
		if(user.usex=="男"){
			$("input[value='男']").prop({"checked":"checked"})
		}else if(user.usex=="女"){
			$("input[value='女']").prop({"checked":"checked"})
		}
	},"text");
	
	
	
	
	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg); //匹配目标参数
	 	if (r != null) return unescape(r[2]); return null; //返回参数值
		}
</script>	
</body>
</html>