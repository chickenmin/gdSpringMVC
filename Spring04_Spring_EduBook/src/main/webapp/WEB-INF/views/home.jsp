<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring EduBook 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<!--TODO 010  -->
	<select id="lang" onchange="langChange()">
		<option value="ko" ${param.lang =="ko"?"selected":""}>한국어</option>
		<option value="en" ${param.lang =="en"?"selected":""}>영어</option>
	</select>
	<script type="text/javascript">
		function langChange(){
			var lang = document.getElementById("lang");
			var choiceValue = lang.options[lang.selectedIndex].value;
			console.log("선택된 언어:"+choiceValue);
			
			location.href='./main.do?lang='+choiceValue;
		}
		
		function descBtn(){
			var desc = document.getElementById("description");
			var btn = document.getElementById("descBtn");
			if (desc.style.display == "none") {
				console.log(desc.style.display);
				desc.style.display = "block"
				btn.textContent = "설명닫기";
			}else{
				desc.style.display = "none"
					btn.textContent = "설명보기";
			}
		}
		
	</script>
	
	<div class="container">
		<form action="./login.do" method="post">
			<table class="table">
				<caption style="text-align: center; font-size: 20px;">
					<spring:message code="label.title"/>
				</caption>
				<tr class="success">
					<th><spring:message code="label.id"/></th>
					<td> 
					<input type="text" name="id" required="required"> </td>
				</tr>
				<tr>
					<th><spring:message code="label.password"/></th>
					<td> <input type="password" name="password" required="required"> </td>
				</tr>
				<tr>
					<th colspan="2">
					<!--TODO 024   -->
					 	<input class="btn btn-warning" type="submit" 
					 	value='<spring:message code="label.login"/>'>
					 	
					 	<!--TODO 072  -->
					 	<input type="button" class="회원가입 form Validation" value="formValidation" onclick="location.href='./formValidation.do'">
					</th>
				</tr>
			</table>
		</form>
	</div>
	<!--TODO 052 Spring Session 설명  -->
	<fieldset>
		<legend>HttpSession과 @SessionAttributes 설명</legend>
		<a href="./sessionInit.do">Session 테스트 이동</a>
		<button onclick="descBtn()" id="descBtn">설명열기</button>
		
		<div id="description" style="display: none;">
<pre>
※ @SessionAttributes를 @ModelAttribute와 이름을 같게 하여 request scope가 아닌
session scope를 사용할 수 있도록 저장해준다

※ 	@SessionAttributes는 4.3버전 이상에서 추가된 Bind Annotation HttpSession 저장값을 컨버팅할 수 있도록 해줌

- 공통
1) sessionInit.do에 의해서 HttpSession과 @SessionAttribute에 값을 담고
	-> sessionCheck.jsp에 출력
	
- 같은 @Contoller의 HttpSession과 @SessionAttribute
2)test01.do
	@SessionAttribute를 삭제하는 SessionStatus.setComplete()

3)test02.do
	HttpSession을 삭제하는 session.invalidate()
	
- 다른 @Controller의 HttpSession과 @SessionAttribute	
2)test03.do
	@SessionAttribute를 삭제하는 SessionStatus.setComplete()

3)test04.do
	HttpSession을 삭제하는 session.invalidate()			
			
* 시나리오(HttpSession : h,  @SessionAttribute :@)
1. 같은 @Controller
	1)sessionInit.do(h,@ 생성) - >result01, result02 확인 -> 모두 사용가능
	2)sessionInit.do(h,@ 생성) - > test01.do @삭제 -> @name오류, h 정상출력
	3)sessionInit.do(h,@ 생성) - > teset02.do h삭제 -> @정상출력, h는 null
	

2. 다른 @Controller
	1)sessionInit.do(h,@ 생성) - > result03, result04 확인 -> h,@는 다른 컨트롤러에서도 같은 방법으로 호출이 가능하다
	2)sessionInit.do(h,@ 생성) - >test03.do @ 삭제 -> @정상출력, h정상출력
	3)sessionInit.do(h,@ 생성) - > test04.do h삭제 - > @삭제, h삭제
	
	<===============================================================================================================>
	결론 : 생성된 클래스가 아닌 다른 Controller에서는 HttpSession 삭제인 invalidate를 통해서 모두 삭제 가능
			같은 Controller인 경우 HttpSession과 @SessionAttribute의 삭제는 개별적으로 이뤄줘야 한다
	<===============================================================================================================>
			
</pre>
		</div>
	</fieldset>
	
	<!--TODO 053  -->
	<fieldset>
		<legend>SMTP</legend>
		<a class="btn btn-success btn-block btn-lg"  href="./mailform.do">메일 작성 화면</a>
	</fieldset>
	
	<!--TODO 060  -->
	<fieldset>
		<legend>파일 업로드 commons-fileupload</legend>
		<a class="btn btn-primary btn-block btn-lg" href="./uploadForm.do">파일 업로드 작성</a>
	</fieldset>
</body>
</html>




















