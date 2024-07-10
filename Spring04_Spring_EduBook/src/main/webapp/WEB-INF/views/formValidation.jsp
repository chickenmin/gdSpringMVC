<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!--TODO 076  -->
</head>
<body>
	<form:form action="./regist.do" method="post" modelAttribute="registValidationDto" >
		<table border="1">
			<tr>
				<th>아이디</th>
				<td>
					<form:input path="id"/>
					<form:errors path="id"/>
				</td>			
			</tr>
			<tr>
				<th>성명</th>
				<td>
					<form:input path="name"/>
					<form:errors path="name"/>
				</td>			
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<form:input path="pw"/>
					<form:errors path="pw"/>
				</td>			
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td>
					<input type="password" id="passwordCheck">
				</td>			
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="가입">
					<input type="button" value="취소" onclick="history.back(-1)">
				</th>
			</tr>
		</table>
	</form:form>
</body>
</html>