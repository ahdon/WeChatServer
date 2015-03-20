<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String contextPath = request.getContextPath();
 %>
<!doctype html>
<html class="wrapper" lang="en">
<head>
	<meta charset="UTF-8">
	<title>CBD</title>
	<link rel="stylesheet" href="./css/main.css">
</head>
<body>
	
		<div class="content">
			<span>CBD</span>
			<form action="<%=contextPath %>/search.action" method="post">
				<input class="ser_input" type="text" name="keyWord">
				<input class="ser_bt" type="submit" value="">
				<input type="hidden" name="currentPage" value="1">
				<input type="hidden" name="changeKeyWord" value="true">
			</form>
		</div>

	
</body>
</html>
