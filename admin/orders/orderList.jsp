<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>         
<%@ page import="domain.Product"%>
<%@ page import="domain.User"%>
<%@ page import="java.util.*"%>
<HTML>
<head>
<meta http-equiv="Content-Language" content="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css2/all.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/home.css">
  
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



	<br />
	<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/FindOrderByConditionServlet" method="post"  accept-charset="UTF-8">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<tr>
				<td align="center" bgColor="#e1e9dd"><strong>查 询 条 件</strong></td>
			</tr>
			<tr>
				<td>
					<table cellpadding="0" cellspacing="0" border="0" width="100%">
						<tr>
							<td height="22" align="center" bgColor="#f5fafe">订单编号：</td>
							<td bgColor="#ffffff"><input type="text" name="id" size="15"
								value="" id="id" /></td>
							<td height="22" align="center" bgColor="#f5fafe">收件人：</td>
							<td bgColor="#ffffff"><input type="text" name="receiverName" size="15"
								value="" id="receiverName" /></td>
									
						</tr>
						<tr>
							<td width="100" height="22" align="center" bgColor="#f5fafe"></td>
							<td bgColor="#ffffff"><font face="宋体" color="red">
									&nbsp;</font></td>
							<td align="right" bgColor="#ffffff"><br /> <br /></td>
							<td align="right" bgColor="#ffffff">
								<button type="submit" id="search" name="search" value="查询">
									查询</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset"
								name="reset" value="重置" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr>
				<td align="center" bgColor="#e1e9dd"><strong>订单 列 表</strong></TD>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">
					<table cellspacing="0" cellpadding="1" rules="all"
						bordercolor="gray" border="1" id="DataGrid1"
						style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
						<tr
							style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #e1e9dd">
							<td align="center" width="20%">订单编号</td>
							<td align="center" width="10%">收件人</td>
							<td align="center" width="9%">地址</td>
							<td align="center" width="9%">联系电话</td>
							<td align="center" width="9%">总价</td>
							<td align="center" width="9%">所属用户</td>
							<td align="center" width="9%">订单状态</td>							
							<td width="8%" align="center">查看</td>
							<td width="8%" align="center">删除</td>
						</tr>
						<!--  循环输出所有商品 -->	
						<c:forEach items="${orders}" var="order">                                                                                                                                                                                                    
								<tr onmouseover="this.style.backgroundColor = 'white'"                                                                                                                                                                                    
									onmouseout="this.style.backgroundColor = '#F5FAFE';">                                                                                                                                                                                 
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="20%">${order.id}</td>                                                                                                                                                    
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10%">${order.receiverName}</td>                                                                                                                                          
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">${order.receiverAddress }</td>                                                                                                                                      
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10%">${order.receiverPhone }</td>                                                                                                                                        
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">${order.money}</td>                                                                                                                                                             
									<td width="8%" align="center">${order.user.username}</td>                                                                                                                                                                             
									<td width="10%" align="center">${order.paystate==0?"未支付":"已支付"}</td>      
							<!-- 查看 -->
							<!-- 查看订单详情，调用FindOrderByIdServlet，并传递订单编号id -->
							<td align="center" style="HEIGHT: 22px" width="7%">
								<a href="${pageContext.request.contextPath }/FindOrderByIdServlet?id=${order.id}">
								<i class="fas fa-search"></i>
								</a>
								</td>
							<!-- 删除 -->
							<!--删除订单，调用DelOrderByIdServlet，并传递订单编号id  -->
							<td align="center" style="HEIGHT: 22px" width="7%">							
								<a href="${pageContext.request.contextPath}/DelOrderByIdServlet?id=${order.id}">
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
</HTML>