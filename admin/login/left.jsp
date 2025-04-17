<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/home.css">
</head>
<body>

    <ul class="lg-left">
        <li><a href="${pageContext.request.contextPath}/ListProductServlet" target="_self">商品管理</a>
        <li><a href="${pageContext.request.contextPath }/admin/login/home.jsp?item=<%="download"%>" target="_self" class="left_list">销售榜单</a></li>
        <li><a href="${pageContext.request.contextPath}/FindOrdersServlet" target="_self" class="left_list">订单管理 </a></li>
        <li><a href="${pageContext.request.contextPath}/ListNoticeServlet" target="_self" class="left_list">公告管理</a></li>
    </ul>

</body>
</html>