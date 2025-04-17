<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="./js/myfail.js"></script>

</head>
<body>
	<%@include file="/client/include/head.jsp" %>
    <%@include file="/client/include/menu_search.jsp" %>
    
<div class="registersuccess-context">
	
	<div class="rs-text">
		<%session.invalidate(); %> 		
		<span>退出登录</span><br>
		<a href="<%=request.getContextPath()%>/client/index.jsp">
			<span id="second">5</span>秒后自动为您转跳回首页
		</a>
	</div> 
</div>  
    
    <%@include file="/client/include/foot.jsp" %>
</body>
</html>