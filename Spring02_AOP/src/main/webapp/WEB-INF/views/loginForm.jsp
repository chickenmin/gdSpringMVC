<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link rel="stylesheet" href="./css/loginForm.css">
</head>
<body>
	<!--
		<form action="" method="">
		form : action 속성을 통해서 submit 이벤트를 통해서 서버 혹은 화면으로 값을 전송
			   method 속성을 통해서 요청 프로토콜을 선택하여 서버로 전송할 수 있다
			     (GET, POST, DELETE, PUT, TRACE...)
			   전송하는 값은 <input>에 값을 작성하고 전송되는 name 속성이 있어야
			   서버에서 name을 통해 값을 전달받는다
		input : form 요소를 통해서 type 속성으로 형태가 변경됨, 문자로만 판단된다
				(text, password, date, color, checkbox, radio)
				submit 을 통해 서버로 전송할 수 있다
				name 속성을 통해 서버에서 전송받을 수 있다
				input = name 속성 + value 속성
	-->

	<!-- 화면에서는 . , 받는 HomeController에서는 / -->
	<form class="box" action="./loginServlet.do" method="post">
		<h1>login</h1>
		<input type="text" name="id" placeholder="Username">
		<input type="password" name="password" placeholder="Password">
		<input type="submit" value="Login">
	</form>
	
</body>
</html>