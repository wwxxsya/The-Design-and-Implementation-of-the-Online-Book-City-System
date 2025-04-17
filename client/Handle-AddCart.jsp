<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");

String s[]=new String[4];
s[0]=request.getParameter("PName");
s[1]=request.getParameter("Price");
s[2]=request.getParameter("PNum");
s[3]="1";

if(s[0].equals("网管员必备宝典")){
	session.setAttribute("book0", s);
}else if(s[0].equals("学会宽容")){
	session.setAttribute("book1", s);
}else if(s[0].equals("杜拉拉升职记")){
	session.setAttribute("book2", s);
}else if(s[0].equals("Java基础入门")){
	session.setAttribute("book3", s);
}
response.sendRedirect("Cart.jsp");

%>
</body>
</html>