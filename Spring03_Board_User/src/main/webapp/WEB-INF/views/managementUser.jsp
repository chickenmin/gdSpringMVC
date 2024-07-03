<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("button[name=btnchk]").click(function(event){
			event.preventDefault();
			var btnOrder = $(this).val();
			console.log(btnOrder);
			
			var chkRow = $("input[name=chkid]:checked")
			for(let i =0; i<chkRow.length;i++){
				console.log(chkRow[i]);
				
				console.log(chkRow[i].parentNode.parentNode.children[4].textContent);
				
				if (btnOrder == "toAuth") {
					chkRow[i].parentNode.parentNode.children[4].textContent = 'A';
				}else if(btnOrder =="toUser" ){
					chkRow[i].parentNode.parentNode.children[4].textContent = 'U';
				}
			}
			changeAjax(btnOrder);
		});
	});
	
	function changeAjax(val){
		var checkCnt = document.querySelectorAll("input[name=chkid]:checked");
		console.log(checkCnt.length);
		
		if (checkCnt.length == 0) {
			alert('한 개이상의 수정 데이터를 선택해주세요');
		}else{
// 			var data = $("form").serializeArray(); //form 요소를 자동으로 key값으로 만들어줌 //첫번재 post사용
			var data = $("form").serialize(); 
			console.log(data);
			console.log("./"+val+".do");
			var pathUrl = "./"+val+".do";
			$.ajax({
				url:pathUrl,
// 				url:"./convertForm.do",
				type:"post",
// 				contentType:"application/json", //첫번재 post사용
// 				data:JSON.stringify(data),	//첫번재 post사용
				data:data,
				success:function(msg){
					console.log(typeof msg,msg);
					if (msg == "true") {
						alert('변경이 완료되었습니다')
					}else{
						alert('변경이 취소되었습니다')
					}
				},
				error:function(){
					alert('잘못된 요청처리');	
				}
			});
		}
	}
</script>
</head>
<body>
	<div class="container">
		<form method="post" onsubmit="return checkBox()">
			<table class="table">
				<thead>
					<tr class="info">
						<th> <input type="checkbox" onclick="allCheck(this.checked)"> </th>
						<th>아이디</th>
						<th>이름</th>
						<th>이메일</th>
						<th>권한</th>
						<th>활성여부</th>
						<th>가입일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${userList}">
						<tr>
							<td><input type="checkbox" name="chkid" value="${vo.id}"> </td>
							<td>${vo.id}</td>
							<td>${vo.name}</td>
							<td>${vo.email}</td>
							<td>${vo.auth}</td>
							<td>${vo.enable}</td>
							<td>${vo.joinindate}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr style="text-align: center;">
						<td colspan="7" >
							<button name="btnchk" value="toAuth"> 관리자로 변경 </button>
							<button name="btnchk" value="toUser"> 일반유저로 변경 </button>
							<button name="btnchk" value="toNonActive"> 비활성화 </button>
							<button name="btnchk" value="toActive"> 활성화 </button>
						</td>
					</tr>
				</tfoot>
				
			</table>
		</form>
	</div>
</body>
</html>