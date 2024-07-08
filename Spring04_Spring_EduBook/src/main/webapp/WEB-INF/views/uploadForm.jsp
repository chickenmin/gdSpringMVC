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
<body>
	<div class="container">
		<!--
		  form tag의 enctype 속성
		  1. application/x-www-form-urlencoded : (default)문자
		  2. multipart/form-data : 파일 업로드 문자+데이터(post)
		  3. text/plain : 인코딩 하지 않겟다
		  
		  파일 업로드 Ajax 사용방법
		  
		  -->
		  
		  <!--TODO 064  -->
		  <form action="./upload.do" method="post" enctype="multipart/form-data">
		  	<h3>업로드할 파일</h3>
		  	파일 : <input type="file" name="file"> <br>
		  	설명 : <br>
		  	<textarea rows="10" cols="40" name="desc" class="content"></textarea>
		  	<input value="전송" type="submit">
		  </form>
		  
		  <!--TODO 071  -->
		  <fieldset>
		  	<legend>AJAX를 통한 이미지 업로드 및 미리보기</legend>
		  	<div>
		  		<input type="file" class="hidden_input" id="reviewImgFileInput" accept="image/*" multiple="multiple"> <!--accept="image/* : 확장자  -->
		  		<!--a태그로 다운로드하는 방법도 있음  -->
		  		<!--차  -->
		  	</div>
		  </fieldset>
	  </div>
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
</body>
</html>