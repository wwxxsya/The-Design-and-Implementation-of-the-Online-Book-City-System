<%@page import="domain.Order"%>
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<head>
	<meta http-equiv="Content-Language" content="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/css2/all.css">
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/home.css">
	
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<table cellSpacing="1" cellPadding="5" width="100%" align="center"
		bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
		<tr>
			<td align="center" bgColor="#e1e9dd" colSpan="4" height="26">
				<strong>
					订单详细信息
				</strong>
			</td>
		</tr>
		<tr>
			<td width="18%" align="center" bgColor="#f5fafe">订单编号：</td>
			<td bgColor="#ffffff">
			 ${orders.id }
			</td>
			<td align="center" bgColor="#f5fafe">所属用户：</td>
			<td bgColor="#ffffff">
			 ${orders.user.username}   
           </td>
		</tr>
		<tr>
			<td align="center" bgColor="#f5fafe">收件人：</td>
			<td bgColor="#ffffff">
			${orders.receiverName}
            </td>
			<td align="center" bgColor="#f5fafe">联系电话：</td>
			<td bgColor="#ffffff">
			${orders.receiverPhone}
            </td>
		</tr>
		<tr>
			<td align="center" bgColor="#f5fafe">送货地址：</td>
			<td bgColor="#ffffff">
    		${orders.receiverAddress}
            </td>
			<td align="center" bgColor="#f5fafe">总价：</td>
			<td bgColor="#ffffff">
  			${orders.money}
            </td>
		</tr>
		<tr>
			<td align="center" bgColor="#f5fafe">下单时间：</td>
			<td bgColor="#ffffff" colSpan="3">
  			${orders.ordertime}
            </td>
		</tr>
		<TR>
			<TD align="center" bgColor="#f5fafe">商品信息</TD>
			<TD bgColor="#ffffff" colSpan="3">
				<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1" 
					style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
					<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #e1e9dd">
						<td align="center" width="7%">序号</td>
						<td align="center" width="18%">商品编号</td>
						<td align="center" width="10%">商品名称</td>
						<td align="center" width="10%">商品价格</td>
						<td width="7%" align="center">购买数量</td>
						<td width="7%" align="center">商品类别</td>
						<td width="31%" align="center">商品描述</td>
					</tr>
					
					<!--  循环遍历集合order.orderItems中的成员-->
					
					<c:forEach items="${orders.orderItems}" var="orderItems" varStatus="vs">
					
						<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #eeeeee">
							<td align="center" width="7%">
							${vs.count}
                            </td>
							<td align="center" width="18%">
							${orderItems.p.id}
                            </td>
							<td align="center" width="10%">
							${orderItems.p.name}
                            </td>
							<td align="center" width="10%">
							${orderItems.p.price}
							</td>
							<td width="7%" align="center">
							${orderItems.buynum}
                            </td>
							<td width="7%" align="center">
							${orderItems.p.category}
                            </td>
							<td width="31%" align="center">
							${orderItems.p.description}
                            </td>
						</tr>
										
				</c:forEach>
					
				</table>
			</TD>
		</TR>
		<TR>
			<td align="center" colSpan="4" class="sep1">
			<!--  <img
				src="${pageContext.request.contextPath}/admin/images/shim.gif">
				-->
			</td>
		</TR>
		<TR>
			<td style="WIDTH: 100%" align="right" bgColor="#f5fafe" colSpan="4">
				<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
				<INPUT type="button" onclick="history.go(-1)" value="返回" /> 
				<span></span>
			</td>
		</TR>
	</table>
</body>
</HTML>