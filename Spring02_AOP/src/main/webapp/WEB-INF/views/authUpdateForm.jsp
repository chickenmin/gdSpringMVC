<%@page import="com.min.edu.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>권한 수정 화면</title>
</head>
<%
	UserDto dto = (UserDto)request.getAttribute("dto");
%>
<body>

	<h2>회원 등급 변경하기</h2>
	<form action="./authUpdate.do" method="post">
		<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
	
		<table>
			<tr>
				<th>아이디</th>
				<td><%=dto.getId()%></td>
			</tr>
			
			<tr>
				<th>이름</th>
				<td><%=dto.getName()%></td>
			</tr>
			
			<tr>
				<th>등급</th>
				<td>
					<select name="role">
						<option value="ADMIN" <%=dto.getAuth().equals("ADMIN")?"selected":""%>>관리자</option>
						<option value="USER" <%=dto.getAuth().equals("USER")?"selected":""%>>사용자</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="권한변경">
					<input type="reset" value="초기화">
				</td>			
			</tr>
			
		</table>
	</form>
</body>
</html>