<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="./js/login.js"></script>
</head>
<body>
	
	<h3>회원가입</h3>
	<form action="./registServlet.do" method="post">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" title="n" name="id">
					<input type="button" value="중복체크" onclick="idCheck()">
				</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="password">
				</td>
			</tr>
			
			<tr>
				<th>성명</th>
				<td>
					<input type="text" name="name"> 
				</td>
			</tr>
			
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="address">
				</td>
			</tr>
			
			<tr>
				<th>전화번호</th>
				<td>
					<input type="text" name="phone">
				</td>
			</tr>
			
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" name="email">
					<input type="button" value="이메일확인" onclick="emailCheck()">
				</td>
			</tr>
			
			<tr>
				<th colspan="2">
					<input type="submit" value="회원가입"> 
				</th>
			</tr>
		</table>
	</form>
</body>
</html>