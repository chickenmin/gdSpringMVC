<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/duplication.js"></script>
</head>

<body>
	<div>
		<h4>아이디 중복검사</h4>
		<h4>아이디를 입력해주세요</h4>
		<input type="text" id="id" class="form-control">
		<input type="button" value="확인 jQuery" class="btn btn-success" onclick="checkId1()">
		<input type="button" value="확인 Fetch" class="btn btn-success" onclick="checkId2()">
		<input type="button" value="사용" class="btn btn-info" id="btnUse" onclick="userId()">
		<div id="condition"></div>
	</div>

</body>


</html>