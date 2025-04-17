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
Connection conn=null;
try{
	//建立与数据库的连接
	conn = DbUtil.getConnection();
}catch(Exception e){
	e.printStackTrace();
}

String email=request.getParameter("email");
String username=request.getParameter("username");
String password=request.getParameter("password");
String gender=request.getParameter("gender");
String telephone=request.getParameter("telephone");
String introduction=request.getParameter("introduction");

	//sql语句
	String sql="insert into user(username,password,gender,email,telephone,introduction)values(?,?,?,?,?,?)";
	
	int result=0;
	//为动态SQL的参数赋值
	try{
		PreparedStatement ps=DbUtil.executePreparedStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, gender);
		ps.setString(4, email);
		ps.setString(5, telephone);
		ps.setString(6, introduction);
		//执行sql语句
		result=ps.executeUpdate();
		ps.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
	//如果执行成功，查询数据库
	if(result>0){
		//查询所有用户信息
		String sqlSearch="select * from user";
		ResultSet rs=null;
		rs=DbUtil.executeQuery(sqlSearch);
		StringBuffer sb=new StringBuffer();
		try{
			//遍历查询结果，拼接为String Buffer对象
			while(rs.next()){
				sb.append("<tr><td>");
				sb.append(rs.getString("username"));
				sb.append("</td><td>");
				sb.append(rs.getString("gender"));
				sb.append("</td><td>");
				sb.append(rs.getString("email"));
				sb.append("</td><td>");
				sb.append(rs.getString("telephone"));
				sb.append("</td><td>");
				sb.append(rs.getString("introduction"));
				sb.append("</td><td>");
				sb.append("<a href='#'>删除</a>");
				sb.append("&nbsp;");
				sb.append("<a href='#'>修改</a>");
				sb.append("</td></tr>");
			}
			//关闭连接
			DbUtil.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		//将查询结果存入session名为search的属性中
		session.setAttribute("search", sb);
		//跳转至registersuccess.jsp,：request.getContextPath()为获取当前web应用的根目录
		response.sendRedirect(request.getContextPath() + "/client/registersuccess.jsp");
	}
	
%>
</body>
</html>