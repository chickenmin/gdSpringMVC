<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/home.do 요청 페이지</title>
</head>
<body>
	<h2>처음 호출되는 페이지</h2>
	<h3>/home.do에서 처리된 request값 : ${name}</h3>
	<fieldset>
		<legend>처리방식에 따른 Controller 호출 연습</legend>
		<ul>
			<li>
				<div>home.do를 GET 방식으로 호출</div>
				<a href="./home.do?name=한글">home Get 호출</a>
				<div>
					 HttpServeltRequest: ${requestScope.req_str} <br>
					 org.springframework.model.ui : ${requestScope.model_str}
				</div>
			</li>
			
			<li>
				<div>home.do를 post 방식으로 호출</div>
				<form action="./home.do" method="post">
					<input type="text" name="name" placeholder="한글입력">
					<input type="submit" value="home Post 전송">
				</form>
			</li>
			<li>
				<div>@RequestMapping을 통한 GET/POST 방식</div>
				<a>info.do GET/POST : Postman</a>
			</li>
			
			<li>
				<div>spring에서의 redirect</div>
				<a href="./redirect.do?name=pororo">redirect.do Get 호출</a>
			</li>
			<li>
				<div>Controller 인덱싱</div>
				<a href="./user/logout.do">인덱싱 요청처리</a>
			</li>
			<li>
				<div>CRUD 및 Transaction, Parameter 처리</div>
				<a href="./selectBoard.do">게시글 전체보기</a>
			</li>
		</ul>
	</fieldset>
</body>
</html>

















