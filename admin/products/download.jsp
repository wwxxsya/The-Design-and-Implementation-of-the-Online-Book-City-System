<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath }/DownloadServlet"
		method="post" accept-charset="UTF-8">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<tr>
				<td align="center" bgColor="#e1e9dd"><strong>查 询 条 件</strong></td>
			</tr>
			<tr>
				<td>
					<table cellpadding="0" cellspacing="0" border="0" width="100%">
						<tr>
							<td height="22" align="center" bgColor="#f5fafe">请输入年份：</td>
							<td bgColor="#ffffff"><input type="text" name="year" size="20"
								value="" id="year" /></td>
							<td height="22" align="center" bgColor="#f5fafe">请选择月份：</td>
							<td bgColor="#ffffff"><select name="month" id="month">
									<option value="0">--选择月份--</option>
									<option value="1">一月</option>
									<option value="2">二月</option>
									<option value="3">三月</option>
									<option value="4">四月</option>
									<option value="5">五月</option>
									<option value="6">六月</option>
									<option value="7">七月</option>
									<option value="8">八月</option>
									<option value="9">九月</option>
									<option value="10">十月</option>
									<option value="11">十一月</option>
									<option value="12">十二月</option>									
							</select></td>
						</tr>
						
						<tr>
							<td width="100" height="22" align="center" bgColor="#f5fafe"></td>
							<td bgColor="#ffffff"><font face="宋体" color="red">
									&nbsp;</font></td>
							<td align="right" bgColor="#ffffff"><br /> <br /><br /></td>
							<td align="right" bgColor="#ffffff">
								<button type="submit" id="search" name="search" value="下载">
									下载</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset"
								name="reset" value="重置" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>