 <%@page import="com.sun.java.accessibility.util.TopLevelWindowListener" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Insert title here</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/home.css">
    </head>

    <body>
    <% request.setCharacterEncoding("UTF-8");  %>
      <div id="login-container">
        <div id="login-header"><%@include file="/admin/login/top.jsp" %></div>

        <div id="login-middle">
          <div class="login-menu"><%@include file="/admin/login/left.jsp" %>   
          </div>
           
          <div id="login-content">
           <% String a=request.getParameter("item"); 
         	if("product_list".equals(a)&&!"null".equals(a)){%>
        	<%@include file="/admin/products/list.jsp" %>
        	<%} else if("product_add".equals(a)&&!"null".equals(a)){%>
        	<%@include file="/admin/products/add.jsp" %>
        	<%} else if("product_edit".equals(a)&&!"null".equals(a)){%>
        	<%@include file="/admin/products/edit.jsp" %>        	
        	<%}else if("download".equals(a)&&!"null".equals(a)){%>
        	<%@include file="/admin/products/download.jsp" %>
        	
        	<%} else if("orders".equals(a)&&!"null".equals(a)){%>
        	<%@include file="/admin/orders/orderList.jsp" %>
        	<%} else if("view".equals(a)&&!"null".equals(a)){%>
        	<%@include file="/admin/orders/orderView.jsp" %>
        	
        	<%} else if("notices".equals(a)&&!"null".equals(a)){%>
        	<%@include file="/admin/notice/noticeList.jsp" %>
        	<%} else if("notice_add".equals(a)&&!"null".equals(a)){%>
        	<%@include file="/admin/notice/addNotice.jsp" %>
        	<%} else if("notice_edit".equals(a)&&!"null".equals(a)){%>
        	<%@include file="/admin/notice/editNotice.jsp" %>
        	<%}
        	else{ %>
          <%@include file="/admin/login/welcome.jsp" %></div>
          <%} %>
        
        
          
        </div>
        <div id="login-footer"><%@include file="/admin/login/bottom.jsp" %></div>     
      </div>
    </body>
    </html>