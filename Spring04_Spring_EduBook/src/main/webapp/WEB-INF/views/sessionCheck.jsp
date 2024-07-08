<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>session 체크</title>
</head>
<body>
	<!--TODO 031  -->
	<fieldset>
		<legend>전달된 값의 확인</legend>
		<div>
			<h2>HttpSession : ${sessionScope.httpSessionTest }</h2>
			<h2>@SessionAttribute : ${sessionScope.sessionTest }</h2>
		</div>
	</fieldset>
	
	<fieldset>
		<legend>@SessionAttribute를 생성한 컨트롤러</legend>
		<ul>
			<li> <!--TODO 032  -->
				<a href="./test01.do">test01.do@SessionAttribute삭제</a>
				<!--TODO 034  -->
				<button onclick="location.href='./result01.do'">결과확인 result01.do</button>
			</li>
			<li> <!--TODO 036  -->
				<a href="./test02.do">test02.do : HttpSession 삭제</a>
				<!--TODO 038  -->
				<button onclick="location.href='./result02.do'">결과확인 result02.do</button>
			</li>
			
			
		</ul>
	</fieldset>
	<fieldset>
		<legend>다른 Controller에서의 session처리</legend>
		<ul>
			<li>
			<!--TODO 039  -->
				<a href="./test03.do">test03.do : @SessionAttributes삭제</a>
				<!--TODO 041  -->
				<button onclick="location.href='./result03.do'">결과확인 result03.do</button>
			</li>
			<li>
				<!--TODO 043  -->
				<a href="./test04.do">test04.do : HttpSession 삭제</a>
				<!--TODO 045  -->
				<button onclick="location.href='./result04.do'">결과확인 result04.do</button>
			</li>
		</ul>
	</fieldset>
</body>
</html>













