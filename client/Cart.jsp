<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/client/css/index.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/client/css/cart.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css2/all.css">
<script type="text/javascript">
//删除购物车中的商品
function cart_del() {   
    var msg = "您确定要删除该商品吗？";   
    if (confirm(msg)==true){   
    return true;   
    }else{   
    return false;   
    }   
}   
</script>
</head>
<body>
	<%@include file="/client/include/head.jsp"%>
	<%@include file="/client/include/menu_search.jsp"%>

	<p:user />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td>
					<div style="text-align: right; margin: 5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath }/client/index.jsp">首页</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;购物车
					</div>
					<table cellspacing="0" class="infocontent">
						<tr>
							<td>

								<table width="100%" border="0" cellspacing="0">

									<tr>
										<td>
											<table cellspacing="1" class="carttable">
												<tr>
													<td width="15%">序号</td>
													<td width="30%">商品名称</td>
													<td width="10%">价格</td>		
													<td width="20%">&nbsp;&nbsp;数量</td>																								
													<td width="10%">小计</td>
													<td width="10%">取消</td>
												</tr>
											</table> <!-- 循环输出商品信息 --> <c:set var="total" value="0" /> <c:forEach
												items="${cart}" var="entry" varStatus="vs">
												<table width="100%" border="0" cellspacing="0">
													<tr>
														<td width="15%">${vs.count}</td>
														<td width="30%">${entry.key.name }</td>
														<td width="10%">${entry.key.price }</td>															
														<td width="20%">${entry.value}</td>														    
														<td width="10%">${entry.key.price*entry.value}</td>
														<td width="10%"><a href="${pageContext.request.contextPath}/changeCartServlet?id=${entry.key.id}&count=0"
														onclick="javascript:return cart_del()"><i class="fas fa-trash-alt"></i></a></td>
													</tr>
												</table>
												<c:set value="${total+entry.key.price*entry.value}"
													var="total" />
											</c:forEach>

											<table cellspacing="1" class="carttable">
												<tr>
													<td style="text-align: right; padding-right: 40px;"><font
														style="color: #FF6600; font-weight: bold">合计：&nbsp;&nbsp;${total}元</font>
													</td>
												</tr>
											</table>
											<div style="text-align: right; margin-top: 10px">
												<!--继续购物 -->
												<a
													href="${pageContext.request.contextPath}/QueryProductByPage">
													<img src="images/gwc_jx.gif" border="0" />
												</a> &nbsp;&nbsp;&nbsp;&nbsp;
												<!--结账 -->
												<a
													href="${pageContext.request.contextPath}/client/order.jsp">
													<img
													src="${pageContext.request.contextPath}/client/images/gwc_buy.gif"
													border="0" />
												</a>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<%@include file="/client/include/foot.jsp"%>

</body>
</html>