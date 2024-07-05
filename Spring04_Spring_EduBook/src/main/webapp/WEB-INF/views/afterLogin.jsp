<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
	<!--TODO 024 -->
		<legend>Scope의 값</legend>
		<ul>
			<li>${requestScope.loginVo }</li>
			<li>${sessionScope.loginVo }</li>
			<li>${loginVo }</li>
		</ul>
	</fieldset>
	
	<div id="page">
		<header id="header">
			<h1>헤더영역</h1>
			${sessionScope.loginVo.name}님 반갑습니다
			<c:if test="${loginVo.auth eq 'A' }">
				<div>
					<a href="#">[게시판보기]</a>
				</div>
				<div>
					<a href="./logout.do">[로그아웃]</a>
				</div>
			</c:if>
		</header>
		<nav id="nav">
			<ul>
				<li>회사소개</li>
				<li>제품소개</li>
				<li>채용정보</li>
				<li>고객센터</li>
			</ul>
		</nav>
			<aside id="aside">
				<div>
					<ul>
						<li>회사연혁</li>
						<li>협력사</li>
						<li>매출</li>
					</ul>
				</div>
			</aside>
			<section id="section">
				<div>
					전달받은 Model 및 HttpSession확인
					<ul>
						<li>Model의 loginVo 값: ${requestScope.loginVo.name}</li>
						<li>session의 loginVo 값:${sessionScope.loginVo.name}</li>
					</ul>
				</div>
				<br>
				<div>
					콘텐츠 메뉴
					<ul>
						<li> <a href="./sessionInit.do">HttpSession의 값을 확인해보자</a> </li>
					</ul>
				</div>
			</section>
			<footer id="footer">
				<div id="copy">
					<p>copyright&copy;</p>
				</div>
			</footer>
	</div>
</body>
</html>





























