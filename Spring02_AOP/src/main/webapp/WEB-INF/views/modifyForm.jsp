<%@page import="com.min.edu.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<%
	UserDto dto = (UserDto)request.getAttribute("info");
%>

<body>

	<form action="./userModifyServlet.do" method="POST">
		<table border="1">
			<thead>
				<tr>
					<th>아이디</th>
					<th>주소</th>
					<th>전화번호</th>
					<th>이메일</th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<th><%=dto.getId()%></th>
					<th><input type="text" name="address" value="<%=dto.getAddress()%>"></th>
					<th><input type="text" name="phone" value="<%=dto.getPhone()%>"></th>
					<th><input type="text" name="email" value="<%=dto.getEmail()%>"></th>
				</tr>
				
			</tbody>
			
			<tfoot>
				<tr>
					<td colspan="4">
						<input type="submit" value="수정">
						<input type="reset" value="초기화">
						<input type="button" value="취소" onclick="javascript:history.back(-1)">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>

</body>
</html>