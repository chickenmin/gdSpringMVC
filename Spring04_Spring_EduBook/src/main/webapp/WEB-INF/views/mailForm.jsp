<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>메일작성화면</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<!--TODO 056  -->
	<div class="container panel-body">
	<h3 class="text-center">메일 보내기</h3>
		<form class="form-horizontal" action="./mailSender.do" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">To:</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email" placeholder="받는 사람" name="email">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">제목:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="email" placeholder="제목" name="title">
				</div>
			</div>
			
			<div class="col-sm-10 col-sm-offset-2">
				<br>
				<div class="form-group">
					<textarea class="form-control" rows="12" name="content" placeholder="메일 내용을 작성해주세요">					</textarea>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-success" value="메일보내기">
					<button class="btn btn-danger" onclick="location.href='./main.do'">취소</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>