<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복체크 결과</title>
<script type="text/javascript">
	window.onload = function(){
		var id = opener.document.getElementsByName("id")[0];
		document.getElementById("inputId").textContent = id.value;
	}

	function confirm(){
		var id = opener.document.getElementsByName("id")[0];
		id.title = "y";
		id.disabled = "disabled";
		self.close();
	}
	
	function cancel(){
		var id = opener.document.getElementsByName("id")[0];
		id.value = "";
		id.focus();
		id.title = "n";
		self.close();
	}
</script>
</head>
<%
	Object obj = request.getAttribute("isc");
	boolean isc = (Boolean)obj;
%>
<body>

	<table border="1">
		<tr>
			<td>
				<div id="inputId"></div>
			</td>
		</tr>
		
		<tr>
			<td>
				<%=isc?"사용할 수 있습니다":"사용할 수 없습니다"%>			
			</td>
		</tr>
		
		<tr>
			<%
				if(isc){
					%>
						<td>
							<input type="button" value="사용하기" onclick="confirm()">
						</td>
					<%
				}else{
					%>
						<td>
							<input type="button" value="창닫기" onclick="cancel()">
						</td>
					<%
				}
			%>
			<td>
				
			</td>
		</tr>
		
	</table>

</body>
</html>