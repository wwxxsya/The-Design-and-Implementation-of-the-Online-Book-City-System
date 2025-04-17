<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css2/all.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/autoplay.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/index.css">
        <script src="${pageContext.request.contextPath}/client/js/autoplay.js"></script>
    </head>

    <body>
        <%@include file="/client/include/head.jsp" %>
        <%@include file="/client/include/menu_search.jsp" %>

             <!-- 图书商城首页轮播图 images/ad/index_ad0.jpg-->

            <div class="app">
                    <div class="scroll">
                        <!-- 图片展示 -->
                        <img src="${pageContext.request.contextPath}/client/images/ad/index_ad0.jpg" alt="scrollImage" class="img current" width="900"
                            height="335">
                        <img src="${pageContext.request.contextPath}/client/images/ad/index_ad1.jpg" alt="scrollImage" class="img" width="900" height="335">
                        <img src="${pageContext.request.contextPath}/client/images/ad/index_ad2.jpg" alt="scrollImage" class="img" width="900" height="335">
                        <img src="${pageContext.request.contextPath}/client/images/ad/index_ad3.jpg" alt="scrollImage" class="img" width="900" height="335">
                        <img src="${pageContext.request.contextPath}/client/images/ad/index_ad4.jpg" alt="scrollImage" class="img" width="900" height="335">

                        <!-- 左右箭头的展示 -->
                        <div class="lf">&lt;</div>
                        <div class="lr">&gt;</div>

                        <!-- 小圆点展示 -->
                        <div class="dots">
                            <span class="square"></span>
                            <span></span>
                            <span></span>
                            <span></span>
                            <span></span>
                        </div>
                    </div>
                </div>

                <div class="message">

                    <div class="announcement">
                       <img src="${pageContext.request.contextPath}/client/images/billboard.gif" alt="">
                       <table cellspacing="0" class="ctl">
						<tr>
							<td width="485" height="100%">${notice.details }</td>
						</tr>
					</table>
				</td>
				<td style="padding:5px 15px 10px 40px">
					<table width="100%" border="0" cellspacing="0">
						<tr>
							<td>
								<img src="${pageContext.request.contextPath}/client/images/hottitle.gif" width="126" height="29" />
							</td>
						</tr>
					</table>
					
              </td>
              </div>
              </div>
            
  
        <%@include file="/client/include/foot.jsp" %>
    </body>

    </html>