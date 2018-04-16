<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>文章管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/datatables.css" rel="stylesheet" type="text/css" media="all" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/datatables.js"></script>
<body>
	<!-- 查询、添加、批量删除、导出、刷新 -->
<div class="row-fluid">
    <div class="pull-right">
        <div class="btn-group">
            <button type="button" class="btn btn-primary btn-sm" id="btn-re">
                <i class="fa fa-refresh"></i> 刷新
            </button>
        </div>
	    </div>
	    <div class="row">
	        <form id="queryForm" action="user/search" method="post">
	            <div class="col-xs-2">
	                <input type="text" id="keyword" name="keyword" class="form-control input-sm"
	                    placeholder="帖子名称">
	            </div>
	            <button type="button" class="btn btn-primary btn-sm" id="btn-query">
	                <i class="fa fa-search"></i> 查询
	            </button>
	        </form>
	    </div>
	</div>
	
	<table id="dataTable" class="table table-striped table-bordered table-hover table-condensed" align="center">
	    <thead>
	        <tr class="info">
	            <td><input type="checkbox" id="checkAll"></td>
	            <th>序号</th>
	            <th>帖子ID</th>
	            <th>标题</th>
	            <th>主题</th>
	            <th>创建时间</th>
	            <th>删除</th>
	        </tr>
	    </thead>
	</table>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/article.js"></script>
</body>

</html>
