<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>[관리자] 사용자 검색</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>[관리자]회원전체조회</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>이름</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${userList}" varStatus="vs">
					<tr>
						<td>${vs.count}</td>
						<td>${vo.id}</td>
						<td>${vo.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<fieldset>
			<legend>회원검색</legend>
			<form name="search-frm" autocomplete="on">
				<select name="type" id="type">
					<option value="id" selected>아이디</option>
					<option value="name">성명</option>
				</select>
				<input type="text" name="keyword" placeholder="검색어를 입력해주세요">
				<input type="button" value="검색" onclick="getSearchUser()">
			</form>
			<div id="viewDetail"></div>
		</fieldset>
	</div>

</body>
<script type="text/javascript">
	function getSearchUser() {
		var opt = document.getElementById("type");
		var keyword = document.getElementsByName("keyword")[0].value;
		var optValue = (opt.options[opt.selectedIndex].value);

		$.ajax({
			url:"./getSearchUser.do",
			method:"post",
			data:{"opt":optValue,"keyword":keyword},
			dataType:"json",	//DEFAULT TEXT
			success:function (msg){
// 				console.log(typeof msg,msg);
// 				console.log(msg["문방사우"][0]);

				var jArray = msg;
				Object.keys(jArray).forEach(function(key){
					console.log(key,jArray[key],jArray[key].name);
				});
				
				for(var key in jArray){
					console.log(key,jArray[key].name)
				}
				
				var html = "<table class='table table-hover'>"
				$.each(msg,function(key,value){
					html+="<tr>";
					html+="<td>"+(key+1)+"</td>";
					html+="<td><a href='./userDetail.do?id="+value.id+"'>"+value.id+"</a></td>";
					html+="<td>"+value.name+"</td>";
					html+="</tr>";
				})
				html+="</table>";
				
				$("#viewDetail").html(html);
				
			//"true"로 보내서 ajax의 dataType:"text"이기에 "true" => String이었음
			// "{\"isc:true}""로 보내서 dataType:"json"이면  => 값이 object로 나오고, obj.isc(값.isc)가 String이 나옴
			// "{\"isc:true}""로 보내서 dataType:"text"이면  => JSON.parse(msg) 해줘야함
			   				 			
		},
			error:function(){
				alert('잘못된 요청 처리');
			}
		})
	}
</script>
</html>


















