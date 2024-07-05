<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring EduBook 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<!--TODO 010  -->
	<select id="lang" onchange="langChange()">
		<option value="ko" ${param.lang =="ko"?"selected":""}>한국어</option>
		<option value="en" ${param.lang =="en"?"selected":""}>영어</option>
	</select>
	<script type="text/javascript">
		function langChange(){
			var lang = document.getElementById("lang");
			var choiceValue = lang.options[lang.selectedIndex].value;
			console.log("선택된 언어:"+choiceValue);
			
			location.href='./main.do?lang='+choiceValue;
		}
	</script>
	
	<div class="container">
		<form action="./login.do" method="post">
			<table class="table">
				<caption style="text-align: center; font-size: 20px;">
					<spring:message code="label.title"/>
				</caption>
				<tr class="success">
					<th><spring:message code="label.id"/></th>
					<td> 
					<input type="text" name="id" required="required"> </td>
				</tr>
				<tr>
					<th><spring:message code="label.password"/></th>
					<td> <input type="password" name="password" required="required"> </td>
				</tr>
				<tr>
					<th colspan="2">
					<!--TODO 024   -->
					 	<input class="btn btn-warning" type="submit" 
					 	value='<spring:message code="label.login"/>'>
					</th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>




















