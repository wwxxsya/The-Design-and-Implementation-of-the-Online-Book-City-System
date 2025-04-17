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
String Delete_book="book"+request.getParameter("i");
session.removeAttribute(Delete_book);
response.sendRedirect("Cart.jsp");
%>
</body>
</html>