<%@page import="com.min.edu.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<script type="text/javascript" src="./js/login.js"></script>
</head>
<%
	UserDto loginDto = (UserDto)session.getAttribute("loginDto");
	if(loginDto == null){
		// 로그인된 세션값이 없다면 root 페이지로
		response.sendRedirect("./");
	}
%>
<body>

	<h2>관리자모드</h2>
	<div>
		<span><%=loginDto.getName()%>님 환영합니다.(등급:<%=loginDto.getAuth()%>)</span>
	</div>
	<div>
		<a href="./loginServlet.do">로그아웃</a>
	</div>
	<div>
		<a href="./userListState.do">회원상태 조회</a>
	</div>
			
	<div>
		<a href="./userListServlet.do">회원정보 조회(사용가능한 계정)</a>
	</div>

</body>
</html>