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
	action="${pageContext.request.contextPath}/EditProductByIdServlet" method="post" accept-charset="UTF-8">
		&nbsp;
		<input type="hidden" name="products_id" value="${products.id}" /> &nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td align="center" bgColor="#e1e9dd" colSpan="4" height="26"><strong><STRONG>修 改 商 品 信 息</STRONG>
				</strong></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">商品名称：</td>
				<td  bgColor="#ffffff" >
					<input type="text" name="products_name" class="bg" value="${products.name}"/>
				</td>
				<td align="center" bgColor="#f5fafe">商品价格：</td>
				<td  bgColor="#ffffff">
					<input type="text" name="products_price" class="bg" value="${products.price}"/>
				</td>				
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品数量：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="products_pnum" class="bg" value="${products.pnum}" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品类别：</td>
				<td class="ta_01" bgColor="#ffffff">
					<select name="products_category" id="category">
						<option value="${products.category}">${products.category}</option>
						<option value="文学">文学</option>
						<option value="生活">生活</option>
						<option value="计算机">计算机</option>
						<option value="外语">外语</option>
						<option value="经营">经营</option>
						<option value="励志">励志</option>
						<option value="社科">社科</option>
						<option value="学术">学术</option>
						<option value="少儿">少儿</option>
						<option value="艺术">艺术</option>
						<option value="原版">原版</option>
						<option value="科技">科技</option>
						<option value="考试">考试</option>
						<option value="生活百科">生活百科</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品图片：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3">
				<input type="file" name="upload" size="30" value="" /></td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">商品描述：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3">
					<textarea name="products_description" cols="30" rows="3" style="WIDTH: 96%">${products.description}</textarea>
				</td>
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