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
	window.onload = function() {
		document.getElementById("btnUse").style.display = "none";
	}
	
	function checkId1(){
		var id = document.getElementById("id").value;
		
		if(id != ""){
			$.ajax({
				url : "./duplicationAjax.do",
				type:"post",
				data:"checkId="+id,	//보내는 값
				dataType:"json",	//보내는 아이의 형변환
				async:true,	//default값
				success:function(msg){
					console.log(typeof msg, msg)
					if(msg.isc == "true"){
						document.getElementById("condition").textContent="사용 가능한 아이디 입니다.";
						document.getElementById("btnUse").style.display = "block";
					}else{
						document.getElementById("condition").textContent="사용할 수 없는 아이디 입니다.";
						document.getElementById("btnUse").style.display = "none";
					}
				},
				error:function(){
					alert("잘못된 요청처리");
				}
			});
		}else{
			alert("아이디를 입력해주세요");
		}
	}
	
	function checkId2(){
		var id = document.getElementById("id").value;
		fetch("./duplicationFetch.do",{
			method:"post",
			headers : {
				"Content-Type":"application/x-www-form-urlencoded"
			},
			body:"checkId="+id
		})
		.then(response => {
			if (!response.ok) {
				throw new Error("잘못된 요청처리");
			}
			return response.text();
		})
		.then(msg => {
			if(msg == "true"){
				document.getElementById("condition").textContent="사용 가능한 아이디 입니다.";
				document.getElementById("btnUse").style.display = "block";
			}else{
				document.getElementById("condition").textContent="사용할 수 없는 아이디 입니다.";
				document.getElementById("btnUse").style.display = "none";
			}
		})
		.catch(error=>{
			alert("잘못된 요청처리")
		});
	}
	
	function userId() {
		var id = document.getElementById("id").value;
		opener.document.getElementById("id").value = id;
		opener.document.getElementById("pw").focus();
		self.close();
	}
	
</script>
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