<%@page import="com.min.edu.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style type="text/css">
	table{
		border: 2px solid blue;
		border-radius: 5px;
		border-collapse: collapse;
		width: 300px;
		margin: 200px auto; /* 젤로 */
	}
	td{
		border: 1px solid pink;
		padding: 10px;
	}
	
</style>
<script type="text/javascript">
	function regist(){
		location.href="./registServlet.do";
	}
</script>
</head>
<%
	// 세션은 브라우저의 모든 곳에서 사용가능하다
	UserDto loginDto = (UserDto)session.getAttribute("loginDto");
%>

<body>
	
	<fieldset>
		<legend>세션의 정보 확인</legend>
		<div>
			<%=loginDto%>
		</div>
	</fieldset>
	
	<form action="./loginServlet.do" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id">
				</td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="text" name="password">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" style="text-align: center;">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="regist()">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>