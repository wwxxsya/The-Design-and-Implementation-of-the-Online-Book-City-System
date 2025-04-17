<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Language" content="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css2/all.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/home.css">
<title>Insert title here</title>
<script type="text/javascript">
	//添加商品
	function addNotice() {
		window.location.href = "${pageContext.request.contextPath}/admin/login/home.jsp?item=<%="notice_add"%>";
	}
</script>
<style type="text/css">
.fas{
	color:#d1d1d1;
}
.fas:hover{
	color:rgba(88, 88, 114, 0.8);
}
</style>
</head>
<body>
<% request.setCharacterEncoding("UTF-8");  %>
	<br />

	<form id="noticelist_form" name="noticeList_form"
		action="${pageContext.request.contextPath}/ListNoticeServlet"
		method="post" accept-charset="UTF-8">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<tr>
				<td align="center" bgColor="#e1e9dd"><strong>公 告 列 表</strong></td>
			</tr>
			<td align="right">
				<button type="button" id="add" name="add" value="添加" onclick="addNotice()">添加</button>
			</td>
			<tr>
				<td align="center" bgColor="#f5fafe">
					<table cellspacing="0" cellpadding="1" rules="all"
						bordercolor="gray" border="1" id="DataGrid1"
						style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
						<tr
							style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #e1e9dd">
							<td align="center" width="9%">公告编号</td>
							<td align="center" width="25%">公告标题</td>
							<td align="center" width="35%">公告内容</td>
							<td align="center" width="15%">时间</td>
							<td align="center" width="8%">编辑</td>
							<td align="center" width="8%">删除</td>
						</tr>
						
						<!--  循环输出所有商品 -->	
						<c:forEach items="${notices}" var="notices">                                                                                                                                                                                                    
								<tr onmouseover="this.style.backgroundColor = 'white'"                                                                                                                                                                                    
									onmouseout="this.style.backgroundColor = '#F5FAFE';">                                                                                                                                                                                 
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="9%">${notices.n_id}</td>                                                                                                                                                    
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="25%">${notices.title}</td>                                                                                                                                          
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="35%">${notices.details }</td>                                                                                                                                      
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">${notices.n_time }</td>                                                                                                                                                                                                                                                                                                  
									 
								<!-- 编辑 -->
							<td align="center" style="HEIGHT: 22px" width="8%">
							<a href="${pageContext.request.contextPath}/FindByIdNoticeServlet?id=${notices.n_id}">
								<i class="fas fa-edit"></i>
								</a></td>
							<!-- 删除 -->
							<td align="center" style="HEIGHT: 22px" width="8%">							
								<a href="${pageContext.request.contextPath}/DelNoticeByIdServlet?id=${notices.n_id}">
								<i class="fas fa-trash-alt"></i>
								</a></td>
								</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>