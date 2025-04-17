<%@page import="util.DbUtil"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
request.setCharacterEncoding("UTF-8");
String username=request.getParameter("username");
String password=request.getParameter("password");

	int state = login(username, password);
	if(state == 1){
	//账户密码正确，则跳回首页
	 request.getSession().setAttribute("username", username);
	 response.sendRedirect(request.getContextPath() + "/client/loginsuccess.jsp");
	}else{
		//账号密码错误
		session.setAttribute("Message", "账号密码错误");
		response.sendRedirect(request.getContextPath() + "/client/loginfail.jsp");
		}
	%>
	
 <%!public int login(String username, String password) throws SQLException{		
		//根据登录时表单输入的用户名和密码，查找用户	 
	 Connection conn=null;
	 try{	 	
	 	conn = DbUtil.getConnection();//建立与数据库的连接
	 }catch(Exception e){
	 	e.printStackTrace();
	 }
	 
		int state = -1;
		String sql="select username,password from user where username='"+username+"'" + "and password='"+password+"'";
		ResultSet rs=null;
		rs=DbUtil.executeQuery(sql);
		if(rs.next()) {
				state = 1;				
				}		
		DbUtil.close();
		return state;		
	}	
	%>
        
</body>
</html>