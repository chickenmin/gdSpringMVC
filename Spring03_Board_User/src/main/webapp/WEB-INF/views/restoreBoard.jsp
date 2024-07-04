<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>삭제글 리스트</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
		${fn:length(restoreList)}
		<table class="table table-hover">
			<thead>
				<tr class="info">
					<th>연번</th>
					<th>아이디</th>
					<th>제목</th>
					<th>등록일</th>
					<th>복구</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${restoreList}" varStatus="vs">
					<tr>
					
						<td>${vo.seq}</td>
						<td>${vo.id}</td>
						<td>${vo.title}</td>
						<td>${vo.regdate}</td>
						<td>
							<button onclick="restorejQuery(this)">jQuery복구</button>							
							<button onclick="restoreFetch(this)">Fetch복구</button>							
							<button onclick="restoreAxios(this)">Axios복구</button>							
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
	
		function restorejQuery(obj){
			var parentTr = obj.closest("tr");
			var seq = parentTr.children[0].textContent;
			console.log(seq);
			
			$.ajax({
				url:"./restore.do",
				method:"get",
				data:{seqs:seq},
				success:function(msg){
					if (msg == 'true') {
						console.log(parentTr.tagName);
						parentTr.remove();
					}
				},
				error:function(){
					alert("잘못된 요청")
				}
			});
			
			
			
		}
		function restoreFetch(obj){
			var parentTr = obj.closest("tr");
			var seq = parentTr.children[0].textContent;
			console.log(seq);
			fetch("./restore.do?seqs="+seq)
			.then(response => response.text())
			.then(data =>{
				if (data == 'true') {
					parentTr.remove();
				}
			})
			.catch(error=>console.log("잘못된 요청처리"));
			
		}
		function restoreAxios(obj){
			var parentTr = obj.closest("tr");
			var seq = parentTr.children[0].textContent;
			axios.get("./restore.do",{
				params:{seqs:seq}
			})
			.then(response => {
				let data = response.data;
				if (data == 'true') {
					parentTr.remove();
				}
			})
			.catch(error => console.log(error))
			parentTr.remove();
		}
	</script>
</body>
</html>