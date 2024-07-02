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
</head>
<script type="text/javascript">

	window.onload = function(){
		document.querySelector("input[type=submit]").onclick = function(event){
			event.preventDefault();
		
		var name = document.getElementById("name");
		var id = document.getElementById("id");
		var password  = document.getElementById("pw");
		var pwOk  = document.getElementById("pwOk");
		var email = document.getElementById("email");
		
		const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;

		
		
		
		if (name.value.length<3) {
			alert("정확한 성명을 작성해주세요");
			return;
		}
		if (password.value != pwOk.value) {
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}
		if (!email.value.match(emailPattern)) {
			alert("잘못된 이메일 형식입니다.");
			return;
		}
		document.forms[0].submit();
		
		}
	}
	
	function duplicate() {
		window.open("./duplicate.do","중복검사","width=500px, height=500px");
	}
</script>
<body>
	<div class="container">
		<form action="./signUp.do" method="post">
			<h2>회원가입</h2>
			<h3>필수 값을 입력하세요</h3>
			
			<div>
				<input class="form-control" type="text" name="name" id="name" placeholder="이름작성">
				<input class="form-control" type="text" name="id" id="id" placeholder="아이디작성(클릭시 중복체크 화면으로 이동)" maxlength="10"
						onclick="return duplicate()">
				<input class="form-control" type="password" name="password" id="pw" placeholder="비밀번호 작성">
				<input class="form-control" type="password" id="pwOk" placeholder="비밀번호 확인">
				<input class="form-control" type="text" name="email" id="email" placeholder="ex)info@gmail.com">
			</div>
			<div>
				<input class="btn btn-primary" type="submit" value="회원가입">
				<input class="btn btn-danger" type="button" value="가입취소" onclick="javascript:history.back(-1)">
			</div>
		</form>	
	</div>

</body>
</html>



















