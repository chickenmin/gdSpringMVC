<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 처리 방법</title>
</head>
<body>	

		<fieldset>
		<legend>Transaction 처리 (Annotation)</legend>
		<form action="./transaction.do" method="post" >
			<input type="text" name="id" value="HAPPY"><br>
			<input type="text" name="title" value="목요일이다"><br>
			<input type="text" name="content" value="내일은 금요일">
			<input type="submit" value="전송">
		</form>
		</fieldset>



	<fieldset>
		<legend>@PathVariable을 통해서 요청 주소에서 parameter 값을 추출</legend>
		<form action="./com/min/edu/user/pathVariable.do">
			<input type="submit" value="주소값처리">
		</form>
	</fieldset>

	<fieldset>
		<legend>@RequestParam 방식으로 전달받은 Parameter 처리</legend>
		<form action="./insertRequestParam.do" method="post">
			<input type="text" name="a" value="오늘은"><br>
			<input type="text" name="b" value="수요일"><br>
			<input type="text" name="c" value="내일은"><br>
			<input type="text" name="d" value="27">
			<input type="submit" value="전송">
		</form>
		</fieldset>
		
	<fieldset>
		<legend>java.util.Map 방식으로 전달받은 Parameter 처리</legend>
		<form action="./insertBoardMap.do" method="post"><br>
			<input type="text" name="id" value="HAPPY"><br>
			<input type="text" name="title" value="목요일이다"><br>
			<input type="text" name="content" value="내일은 목요일"><br>
			<input type="submit" value="전송">
		</form>
		</fieldset>
		
	<fieldset>
		<legend>dto/vo 방식으로 전달받은 Parameter 처리</legend>
		<form action="./insertBoardVo.do" method="post" ><br>
			<input type="text" name="id" value="HAPPY"><br>
			<input type="text" name="title" value="목요일이다"><br>
			<input type="text" name="content" value="내일은 목요일">
			<input type="submit" value="전송">
		</form>
		</fieldset>
		
		<fieldset>
			<label>전달받은 requestScope</label>
			${lists}
		</fieldset>
	
</body>
</html>