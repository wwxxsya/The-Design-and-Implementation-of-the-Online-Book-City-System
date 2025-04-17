<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/index.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css2/all.css">
</head>
<body>
    <div class="top-nav-bar">
        <div class="nav">
            <ul class="top">
            	
				<%String username=(String)session.getAttribute("username"); %>
                <li>
                <%                
                if(username!=null) out.print("<a href='./client/log-out.jsp'>"+"用户退出"+"</a>");
                else out.print("<a href='../client/register.jsp'>"+"新用户注册"+"</a>");
                %>               
              </li>
                <li><a href="">我的账户</a></li>
                <li><a href="">帮助中心</a></li>
                <li><a href="${pageContext.request.contextPath}/client/Cart.jsp"><img src="${pageContext.request.contextPath}/client/images/cart.gif" alt="">购物车</a></li>         
            </ul>            
        </div><br>
        <div class="session"><%if(username!=null) out.print("欢迎您："+username); %></div>
    </div>
    <div class="title1">
        <a href=""><img src="${pageContext.request.contextPath}/client/images/logo.jpg" alt=""></a>
    </div>

</body>
</html>