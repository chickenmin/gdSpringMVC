<%@page import="com.min.edu.dto.UserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상태조회 페이지</title>
</head>
<%
	// <% scriptlet 영역 : 자바의 문법을 작성
	List<UserDto> lists = (List<UserDto>)request.getAttribute("lists");
%>
<body>
<!-- Expression 자바 객체의 값을 출력 -->
<%=lists%>

<h2>회원상태정보 전체 조회</h2>
<table>
	<thead>
		<tr>
			<th>SEQ(시퀀스)</th>
			<th>ID(아이디)</th>
			<th>NAME(성명)</th>
			<th>ADDRESS(주소)</th>
			
			<th>PHONE(전화번호)</th>
			<th>EMAIL(이메일)</th>
			<th>ENABLE(사용여부)</th>
			<th>AUTH(권한)</th>
		</tr>
	</thead>
	<tbody>
		<%
			for(UserDto dto : lists){
				%>
				<tr>
					<td><%=dto.getSeq()%></td>
					<td><%=dto.getId()%></td>
					<td><%=dto.getName()%></td>
					<td><%=dto.getAddress()%></td>

					<td><%=dto.getPhone()%></td>
					<td><%=dto.getEmail()%></td>
					<td><%=dto.getEnable().equals("Y")?"사용중":"탈퇴"%></td>
					<td><%=dto.getAuth()%></td>
				</tr>
				<%
			}
		%>
	</tbody>
	<tfoot>
		<tr>
			<th colspan="8">
				<button onclick="history.back(-1)">처음화면 이동</button>
			</th>
		</tr>
	</tfoot>
	
</table>

</body>

</html>