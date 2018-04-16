<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>KBlog后台管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/login.css">
<body>
	<div class="agile-login">
		<h1>KBlog后台管理系统</h1>
		<div class="wrapper">
			<h2>登录</h2>
			<div class="w3ls-form">
				<form action="login/login" method="post">
					<label>用户名或邮箱</label>
					<input type="text" name="name" required/>
					<label>密码</label>
					<input type="password" name="password" required />
					<input type="submit" value="Log In" />
				</form>
			</div>
		</div>
		<br>
	</div>
	
	<script type="text/javascript">
		var error = '${error}';
		if(error != "") {
			alert(error);
		}
	</script>
</body>

</html>
