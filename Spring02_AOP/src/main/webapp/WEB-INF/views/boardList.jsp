<%@page import="com.min.edu.dto.AnswerBoardDto"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 후 전체글보기</title>
</head>
<%!
	//JSP에서 java의 메소드를 작성 할 수 있는 영역
	//날짜 표시 형식을 2024-06-11 14:46:12을 2024년 6월 11일 - String -> Date ->String
	
	public String dateFormatPattern(String oldDate){
		String newDate = "";
		Date cDate = null;
		Date nowDate = null;
		SimpleDateFormat sdf2 =null;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			cDate = sdf.parse(oldDate);
		 	nowDate = new Date();
			sdf2 = new SimpleDateFormat("yyyy년-MM월-dd일");
		}catch(ParseException e){
			e.printStackTrace();
		}
		return sdf2.format(cDate).compareTo(sdf2.format(nowDate)) == 0 ? "오늘작성": sdf2.format(cDate);
	};
	
	//답글 depth에 따라서 공백과 이미지를 넣어 주는 메소드
	public String photo(int depth){
		String replyStr = "";
		
		String img = "<img alt='답글' src='./img/reply.png'>";
		String blank ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		
		for(int i=0; i<depth; i++){
			replyStr += blank;
		}
		
		return (depth>0)?replyStr+img:replyStr;
	};
	
%>

<%
List<AnswerBoardDto> lists = (List<AnswerBoardDto>)request.getAttribute("lists");
//   List<AnswerboardDto> lists = new ArrayList();
%>
<!-- 헤더영역 include -->
<%@ include file="./header.jsp"%>
<body>
<!-- JAVA의 객체를 action tag를 통해서 객체를 생성(instance)한다 -->
<jsp:useBean id="dBean" class="com.min.edu.comm.DateFormatPatternBean" scope="page"/>
<jsp:useBean id="pBean" class="com.min.edu.comm.PhotoBean" scope="page"/>

	<!-- content 영역 -->
	<div id="container" class="container">
		<form action="./multiDelete.do" method="post"
			onsubmit="return chkSubmit()">
			<table class="table table-horver">
				<thead>
					<tr class="info">
						<th><input type="checkbox" id="chkbox" class="allCheckBox" onclick="checkAll(this.checked)"></th>
						<th>연번</th>
						<th>작성자</th>
						<th>제목</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<%
					if (lists.size() == 0) {
					%>
					<tr>
						<td colspan="5"
							style="color: blue; font-size: 15px; text-align: center;">--
							작성된 글이 없습니다--</td>
					</tr>
					<%
					} else {
					int idx = 0;
					for (AnswerBoardDto dto : lists) {
					%>
					<tr>
						<td><input type="checkbox" name="ch" class="ch"
							value="<%=dto.getSeq()%>"></td>
						<td><%=lists.size() - (idx++)%></td>
						<td><%=dto.getName()%></td>
						<td>
							<jsp:setProperty property="depth" name="pBean" value="<%=dto.getDepth()%>"/>
							<jsp:getProperty property="photo" name="pBean"/>
							<%
							if (dto.getDelflag().equalsIgnoreCase("y")) {
							%> <span
							style="font-size: 8px; color: #ccc;">관리자에 의해서 삭제되었습니다.</span> <%
						 } else {
						 %> 
						 <a href="./detailBoard.do?seq=<%=dto.getSeq()%>"><%=dto.getTitle()%></a>
						<%
						}
					%>
						</td>
						<jsp:setProperty property="oldDate" name="dBean" value="<%=dto.getRegdate()%>"/>
						<td>
							<jsp:getProperty property="dateFormatPattern" name="dBean"/>
						</td>
					</tr>
					<%
					}

					}
					%>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5" style="text-align: center;">
						<!-- form 속성인 onsubmit을 통한 제어 -->
						<input type="submit" class="btn btn-success" value="다중삭제01">
						<!--  -->
						<input type="submit" class="btn btn-info" value="다중삭제02" onclick="chSubmit(event)">
						<input type="button" class="btn btn-primary" value="새글입력" onclick="location.href='./writeBoard.do'"></td>
						
					</tr>
				</tfoot>
			</table>
		</form>
	</div>

	<!-- 푸터영역 include -->
	<%@ include file="./footer.jsp"%>
</body>
</html>