<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>파일 다운로드</title>
</head>
<body>
	<fieldset>
		<legend>저장된 파일 정보</legend>
		<div>
			<!--TODO 067  -->
			<ul>
				<li>${path}</li>
				<li>${originFileName}</li>
				<li>${saveFileName}</li>
				<li>
					<img  src="./storage/${saveFileName}">
				</li>
			</ul>
		</div>
		
		<!--TODO 068  -->
		<div>
			<div>파일 다운로드 Attachment header 정보 확인</div>
			<form action="./download.do" method="post">
				<input type="text" name="originFileName" value="${originFileName }" readonly="readonly">
				<input type="text" name="saveFileName" value="${saveFileName }" readonly="readonly">
				<input type="submit" value="파일 다운로드">
			</form>
		</div>
	</fieldset>
</body>
</html>













