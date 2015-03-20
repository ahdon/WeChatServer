<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;  charset=UTF-8"%>
  <%@ page pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>CBD</title>
	<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<div class="mainbody">
		<div class="search_area">
			<img class="logo_img" src="images/logo.png" alt="">
			<form action="search.action" method="post">
				<input class="result_input" type="text" name="keyWord" value='<s:property value="keyWord" />'>
				<input class="result_bt" type="submit" value="">
				<input type="hidden" name="currentPage" value="1">
				<input type="hidden" name="changeKeyWord" value="true">
			</form>
		</div>
		<div class="bodycontent">
		<p class="result_sum">共搜到 <span style="color:#ff0000"><s:property value="recordCount" /></span> 条结果</p>
		
		
		<div class="result_area">
		<s:iterator value="subResultList" var="urlresult">
		<div class="result_item">
				<a class="result_webside"  target="_blank" href="<s:property value="#urlresult.url" />"><s:property value="#urlresult.title" escape="false"/></a>
				<p><s:property value="#urlresult.context" escape="false"/></p>
				<p class="result_source"><s:property value="#urlresult.url"/></p>
			</div>
		</s:iterator>
			<!------------分页------------>
			<div class="page">
				<s:if test="recordCount!=0">
				<s:if test="currentPage!=1">
					<a href="search.action?currentPage=1&&changeKeyWord=false">第一页</a>
					<a href="search.action?currentPage=<s:property value="currentPage-1"/>&&changeKeyWord=false">上一页</a>
				</s:if>
				<a class="active" href="#"><s:property value="currentPage"/></a>
				<s:if test="pageCount>=currentPage+1">
				<a href="search.action?currentPage=<s:property value="currentPage+1"/>&&changeKeyWord=false"><s:property value="currentPage+1"/></a>
				</s:if>
				<s:if test="pageCount>=currentPage+2">
				<a href="search.action?currentPage=<s:property value="currentPage+2"/>&&changeKeyWord=false"><s:property value="currentPage+2"/></a>
				</s:if>
				<s:if test="pageCount>=currentPage+3">
				<a href="search.action?currentPage=<s:property value="currentPage+3"/>&&changeKeyWord=false"><s:property value="currentPage+3"/></a>
				</s:if>
				<s:if test="pageCount>=currentPage+4">
				<a href="search.action?currentPage=<s:property value="currentPage+4"/>&&changeKeyWord=false"><s:property value="currentPage+4"/></a>
				</s:if>
				<s:if test="pageCount>=currentPage+1">
				<a href="search.action?currentPage=<s:property value="currentPage+1"/>&&changeKeyWord=false">下一页</a>
				</s:if>
				</s:if>
			</div>
		</div>

		<div class="member">
			<ul class="member_list">
				<li>关于CBD</li>
				<li>
					<img src="images/zyd.jpg" alt="">
					<span>张羽东</span>
					<p>主要负责：算法实现</p>
				</li>
				<li>
					<img src="images/hby.jpg" alt="">
					<span>黄宝怡</span>
					<p>主要负责：文档编写</p>
				</li>
				<li>
					<img src="images/hql.jpg" alt="">
					<span>黄启林</span>
					<p>主要负责：网页重构</p>
				</li>
				<li>
					<img src="images/hwd.jpg" alt="">
					<span>洪伟达</span>
					<p>主要负责：界面设计</p>
				</li>
			</ul>
		</div>
		</div>
		<div class="footer">
			<span>©2014 CBD 老师给分给高点呗~</span>
		</div>
	</div>
</body>
</html>