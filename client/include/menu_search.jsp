<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/index.css">
</head>
<body>

<form>
<div class="wrapper">
    <div class="upper-nav">
        <ul class="nav2">
            <li><a href="${pageContext.request.contextPath}/QueryProductByPage?category=文学">文学</a> </li>
            <li><a href="${pageContext.request.contextPath}/QueryProductByPage?category=生活">生活</a></li>
            <li><a href="${pageContext.request.contextPath}/QueryProductByPage?category=计算机">计算机</a></li>
            <li><a href="${pageContext.request.contextPath}/QueryProductByPage?category=外语">外语</a></li>
            <li><a href="${pageContext.request.contextPath}/QueryProductByPage?category=经管">经管</a></li>
            <li><a href="${pageContext.request.contextPath}/QueryProductByPage?category=励志">励志</a></li>
            <li><a href="${pageContext.request.contextPath}/QueryProductByPage?category=社科">社科</a></li>
            <li><a href="${pageContext.request.contextPath}/QueryProductByPage?category=学术">学术</a></li>
            <li><a href="${pageContext.request.contextPath}/QueryProductByPage?category=少儿">少儿</a></li>
            <li><a href="${pageContext.request.contextPath}/QueryProductByPage?category=艺术">艺术</a></li>
            <li><a href="${pageContext.request.contextPath}/QueryProductByPage?category=原版">原版</a></li>
            <li><a href="${pageContext.request.contextPath}/QueryProductByPage?category=科技">科技</a></li>
            <li><a href="${pageContext.request.contextPath}/QueryProductByPage?category=考试">考试</a></li>
            <li><a href="${pageContext.request.contextPath}/QueryProductByPage?category=生活百科">生活百科</a></li>           
            <li class="allitems"><a href="${pageContext.request.contextPath}/QueryProductByPage">全部商品目录</a></li>
            <li class="clear"></li>
           
        </ul>
         <div class="clear"></div>
    </div>
    </div>
    </form>
    <form action="${pageContext.request.contextPath }/MenuSearchServlet">
    <div class="nether-nav">
      <table>
          <tr>
              <td>Search</td>
              <td><input type="text" class="textfield" name="textfield" id="textfield" placeholder="请输入书名"></td>
              <td><input type="image" class="searchButton" name="searchButton" id="searchButton" src="${pageContext.request.contextPath}/client/images/serchbutton.gif"></td>
          </tr>

      </table>
    </div>
</form>
</body>
</html>