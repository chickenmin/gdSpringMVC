<%@page import="com.min.edu.dto.AnswerBoardDto"%>
<%@page import="com.min.edu.dto.AnswerBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>글 상세 페이지</title>
</head>
<%
	AnswerBoardDto dto = (AnswerBoardDto)request.getAttribute("dto");
%>

<%@include file="./header.jsp" %>
<body>
	<div id="container">
		<table class="table talbe-condensed">
			<tbody>
				<tr>
					<td class=info>아이디</td>
					<td><%=dto.getId()%></td>
				</tr>
				
				<tr>
					<td class=info>제목</td>
					<td><%=dto.getTitle()%></td>
				</tr>
				
				<tr>
					<td class=info>내용</td>
					<td>
						<textarea rows="5" cols="50" readonly="readonly"><%=dto.getContent()%></textarea>
					</td>
				</tr>
				<tr>
					<td class=info>등록일</td>
					<td><%=dto.getRegdate()%></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<form class="btn-group btn-group-justified">
							<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
							<%
								if(loginDto.getAuth().equalsIgnoreCase("A")){
									%>
									<div class="btn-group">
										<button class ="btn btn-danger" onclick="del(event)">관리자 삭제</button>
									</div>
									<%
				
									
								}
							%>
							<%
								if(loginDto.getId().equals(dto.getId())){
									%>
									<div class="btn-group">
										<button class="btn btn-info" onclick="modify(event)">내 글수정</button>
									</div>
									<%
								
								
							}
							%>
							
							<div class="btn-group">
								<button type="button" class="btn btn-primary" onclick="reply(event)">답글</button>
							</div>
						</form>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
<%@include file="./footer.jsp" %>
</html>