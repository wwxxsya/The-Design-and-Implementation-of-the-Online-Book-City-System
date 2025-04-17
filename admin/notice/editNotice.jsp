<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css2/all.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/home.css">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8");  %>
	<form id="addnotice" name="addnotice" 
	action="${pageContext.request.contextPath}/EditNoticeByIdServlet" method="post" accept-charset="UTF-8">
		&nbsp;
		<input type="hidden" name="notice_id" value="${n.n_id}" /> &nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td align="center" bgColor="#e1e9dd" colSpan="4" height="26"><strong><STRONG>修 改 公 告</STRONG>
				</strong></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">公告标题：</td>
				<td  bgColor="#ffffff" colSpan="3">
					<input type="text" name="notice_title" class="bg" maxlength="10"  value="${n.title }"/>
				</td>				
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">公告内容：</td>
				<td bgColor="#ffffff" colSpan="3"><textarea name="notice_context"
						cols="30" rows="5" style="WIDTH: 96%">${n.details }</textarea></td>				
			</tr>			
			<tr>
				<td style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
					<input type="submit" value="确定"> <FONT face="宋体">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<input type="reset" value="重置"> <FONT face="宋体">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </FONT> 
					<INPUT type="button" onclick="history.go(-1)" value="返回" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>