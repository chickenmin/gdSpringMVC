<%@page import="com.min.edu.dto.AnswerBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내글 수정입력 화면</title>
</head>
<%@ include file="./header.jsp" %>
<%
	AnswerBoardDto dto = (AnswerBoardDto)request.getAttribute("dto");
%>
<body>

	<div id="container">
		<div>ModifyBoardServlet GET의 parameter : <%=request.getParameter("seq")%></div>
		<form action="./modifyBoard.do" method="post">
			<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
			<table class="table table-condensed">
				<tr>
					<th class="info">아이디</th>
					<td><%=dto.getId()%></td>
				</tr>
				
				<tr>
					<th class="info">제목</th>
					<td><%=dto.getTitle()%></td>
				</tr>
				
				<tr>
					<th class="info">내용</th>
					<td>
						<textarea rows="5" class="form-control" name="content" id="content"><%=dto.getContent()%></textarea>
					</td>
				</tr>
				
				<tr>
					<th colspan="2" style="text-align: center;">
						<input type="submit" value="수정완료">
						<input type="button" value="뒤로가기" onclick="javascript:history.back(-1)">
					</th>
				</tr>
			</table>
		</form>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>