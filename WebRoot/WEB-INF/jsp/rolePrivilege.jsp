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
    <title>配置权限管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/bootstrap-select.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/datatables.css" rel="stylesheet" type="text/css" media="all" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap-select.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/datatables.js"></script>
<body>

	<!-- 查询、添加、批量删除、导出、刷新 -->
	
<div class="row-fluid">
    <div class="pull-right">
        <div class="btn-group">
            <button type="button" class="btn btn-primary btn-sm" id="btn-add">
                <i class="fa fa-plus"></i> 增加
            </button>
            <button type="button" class="btn btn-primary btn-sm" id="btn-re">
                <i class="fa fa-refresh"></i> 刷新
            </button>
        </div>
	    </div>
	    
	    <div class="row">
	        <form id="queryForm" method="post">
                <input type="hidden" id="keyword" name="keyword" value="${roleId }" class="form-control input-sm">
	        </form>
	    </div>
	</div>
	
	<table id="dataTable" class="table table-striped table-bordered table-hover table-condensed" align="center">
	    <thead>
	        <tr class="info">
	            <td><input type="checkbox" id="checkAll"></td>
	            <th>序号</th>
	            <th>权限ID</th>
	            <th>权限</th>
	            <th>删除</th>
	        </tr>
	    </thead>
	</table>
<div class="container">
        <div class="modal fade" id="editModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="btn-info modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4>配置权限</h4>
                    </div>
					
                    <div class="modal-body">
                        <form id="editForm" class="form-horizontal" role="form">
                        	<input type="hidden" id="roleId" name="roleId" value="${roleId }">
                            <div class="form-group">
                                <label for="roleId" class="col-sm-2 control-label">权限</label>
                                <div class="col-sm-9">
                                    <select id="privilegeList2" id="privilegeId" name="privilegeId" style="width: 150px"> 
                                    </select>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" id="btn-submit" class="btn btn-info">确定</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>
</div>
	<script type="text/javascript" src="js/rolePrivilege.js"></script>
</body>

</html>
