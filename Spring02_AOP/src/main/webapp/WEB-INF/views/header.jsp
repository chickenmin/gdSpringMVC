<%@page import="com.min.edu.dto.UserInfoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상단 메뉴바</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- CSS 파일 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.10.8/dist/sweetalert2.min.css">

<!-- JS 파일 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/sweetalert2@11.10.8/dist/sweetalert2.all.min.js"></script>

<script type="text/javascript" src="./js/answerboard.js"></script>

<style type="text/css">
	#container{
		width: 800px;
		margin: 50px auto;
		height: 70vh;
	}
	
	header{
		background: #015937;
		height: 100px;
		color: #000000;
	}
	footer{
		background: #015937;
		text-align: center;
		line-height: 20px;
		padding: 20px;
	}
	.navbar .navbar-inverse {
		margin-top: 25px;
		
	}
</style>

</head>
<body>
${loginDto}

	<%
		UserInfoDto loginDto = (UserInfoDto) session.getAttribute("loginDto");
	%>
   <header>
      <div style="padding: 30px;">
         <h3 style="display: inline;">
            <a href="./boardList.do">게시판 구현</a>
         </h3>

         <%
         if (loginDto == null) {
         %>
         <div style="display: inline; float: right;">
            <button class="btn btn-info" onclick="location.href='./loginServlet.do'">Sign In</button>
         </div>
         <div>
            <button class="btn btn-primary">Sign Up</button>
         </div>
         <%
         } else {
         %>
         <div style="display: inline; float: right;">
            <span style="color: white;">
            	아이디:<%=loginDto.getId()%>(<%=loginDto.getAuth().equalsIgnoreCase("A") ? "관리자" : "사용자"%>);
            </span>
            <button class="btn btn-warn">MyPage</button>
            <button class="btn btn-danger" onclick="location.href='./loginServlet.do'">Logout</button>
         </div>
         <%
         }
         %>
      </div>


      <nav class="navbar navbar-inverse">
         <div class="container-fluid">
            <div class="navbar-header">
               <a class="navbar-brand" href="#">WebSiteName</a>
            </div>
            
            <ul class="nav navbar-nav">
               <li class="active">
               		<a href="#">Home</a>
               </li>
               
               <li class="dropdown">
               		<a class="dropdown-toggle" data-toggle="dropdown" href="#">
               			Page 1<span class="caret"></span>
               		</a>
                  	<ul class="dropdown-menu">
                    	<li><a href="#">Page 1-1</a></li>
                    	<li><a href="#">Page 1-2</a></li>
                    	<li><a href="#">Page 1-3</a></li>
                  	</ul>
               </li>
               
               <li><a href="#">Page 2</a></li>
               
               <li><a href="#">Page 3</a></li>
            </ul>
         </div>
      </nav>

   </header>
   <div>
      로그인된 정보:
      <%=loginDto%></div>

</body>
</html>