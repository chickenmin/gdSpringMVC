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
<body>
	<div class="container">
		<!--
		  form tag의 enctype 속성
		  1. application/x-www-form-urlencoded : (default)문자
		  2. multipart/form-data : 파일 업로드 문자+데이터(post)
		  3. text/plain : 인코딩 하지 않겟다
		  
		  파일 업로드 Ajax 사용방법
		  var form = document.forms[0];
		  var formData = new FormData(frm);
		  
		  var file = document.querySelector("input[type=file]");
		  var formData = new FormData();
		  formData.append("file",file);
		  
		  $.ajax({
		  url : "",
		  enctype:"multipart/form-data",
		  processData:false,	//서버에 전송할 데이터가 쿼리스트링으로 되어 있는지 여부 (true:쿼리스트링으로 보내겟다 , false:데이터로 보내겟다)
		  contentType:false,	//false로 작성하면 enctype사용 가능
		  data:formData,		//AJAX는 HTML의 FORM데이타를 전송할 수 없기에 new FormData()객체를 보내야 한다
		  type:"post",
		  success:function(){},
		  error:function(){}
		  });
		  
		  
		  -->
		  
		  <!--TODO 064  -->
		  <form action="./upload.do" method="post" enctype="multipart/form-data">
		  	<h3>업로드할 파일</h3>
		  	파일 : <input type="file" name="file"> <br>
		  	설명 : <br>
		  	<textarea rows="10" cols="40" name="desc" class="content"></textarea>
		  	<input value="전송" type="submit">
		  </form>
		  
		  <!--TODO 071  -->
		  <fieldset>
		  	<legend>AJAX를 통한 이미지 업로드 및 미리보기</legend>
		  	<div>
		  		<input type="file" class="hidden_input" id="reviewImgFileInput" accept="image/*" multiple="multiple"> <!--accept="image/* : 확장자  -->
		  		<!--a태그로 다운로드하는 방법도 있음  -->
		  		<!--차  -->
		  	</div>
		  	<div>
		  		<ul class="list_thumb"></ul>
		  	</div>
		  </fieldset>
		  
		  <script type="text/javascript">
		  	window.onload = function(){
		  		document.getElementById("reviewImgFileInput").onchange = function(){
		  			console.log("파일 업로드 버튼 실행");
		  			var imgFile = this.value.toLowerCase();
		  			var fileForm = /(.*?)\.(jpg|jpeg|bmp|png|gif|pdf)/;
		  			var maxSize = 5*1024*1024;
		  			var fileSize = document.getElementById("reviewImgFileInput").files[0].size;
		  			
		  			console.log(imgFile, fileForm,maxSize, fileSize );
		  			
		  			var checkImgTest = fileForm.test(imgFile);	//true/false
		  			var checkImgMath = imgFile.match(fileForm)	//객체 혹은 null
		  			
		  			if(checkImgMath){
		  				console.log("if 객체가 있으면 true이기 때문에");
		  			}
		  			
		  			if(!checkImgTest){ 	//정규화가 맞다면 true, 아니라면 false
		  				alert("이미지 파일만 가능합니다");
		  				return;
		  			}
		  			if(maxSize < fileSize){
		  				alert("이미지 파일은 5MB만 이하만 가능합니다.");
		  				return;
		  			}
		  			//이미지 미리보기 작동 fn
		  			readUrl(this);
		  			
		  		}
		  	}
		  	
		  	function readUrl(input){
		  		const target = document.getElementById("reviewImgFileInput");
		  		const  fileLength = target.files.length;
		  		console.log("파일검색 : ",target.files);
		  		
		  		/* 여러개의  JSON Array값을 출력하는 방법
		  		Object.keys(jArray).forEach(function(key){
		  		console.log(key, jArray[key], jArray[key].name);
		  		});
		  		for(var key in jArray){
		  		console.log(key, jArray[key].name)
		  		}
		  		$.each(msg,function(key,value){})
		  		*/
		  		
		  		$.each(target.files, function(index,file){
		  			var render = new FileReader();
		  			render.onload = function(e){
		  				var info = e.target.result;
		  				console.log(info);
		  				let reviewImg = "<li class='item' style=''>";
		  				 reviewImg += "<a href='#' class='anchor'>";
		  				 reviewImg += "<span class='subImg'>전송</span>";
		  				 reviewImg += "</a>";
		  				 reviewImg += "<img src ='"+e.target.result+"' width='50px' class='item_thumb'>";
		  				 reviewImg += "<button class='deleteImg'>삭제</button>"
		  				 reviewImg += "<span class ='img_border'></span>"
		  				 reviewImg += "</li>";
		  				$(".list_thumb").append(reviewImg);
		  				
		  			}
		  			render.readAsDataURL(file);
		  		});
		  	}
		  	
		  	document.querySelector(".list_thumb").addEventListener('click',function(event){
		  		if(event.target.classList.contains('deleteImg')){
		  			event.target.parentElement.remove();
		  		}
		  		if(event.target.classList.contains('subImg')){
		  			imageSubmit();
		  		}
	  		});
		  	
		  	function imageSubmit(){
		  		console.log("이미지 ajax 저장");
		  		let content = document.querySelector(".content").value;
		  		let reviewImgFileInput = document.getElementById("reviewImgFileInput").files;
		  		console.log("전송글자 : ",content);
		  		console.log("전송파일 : ",reviewImgFileInput.length);
		  		
		  		/* let formData = new FormData();
		  		if(reviewImgFileInput.length >= 1){
		  			for(let  i =0;i<reviewImgFileInput.length;i++){
		  				formData.append("file",reviewImgFileInput[i]);
		  			}
		  		}
		  		formData.append("decs",content);
		  		console.log(formData.getAll("file"));
		  		console.log(formData.get("decs"));
		  		
		  	$.ajax({
		  		url : "./uploadAjax.do",
		  		type:"post",
		  		async:false,
		  		data:formData,
		  		contentType:false,
		  		processData:false,
		  		dataType:"json",
		  		success:function(msg){
		  			console.log(typeof msg, msg);
		  			if(msg.isc == "true"){
		  				alert("작성완료");
		  			}
		  			
		  		},
		  		error : function(request, error, status){
		  			alert(request,error)
		  		}
		  	}); */
		  	
		 // ###########  li tag의 base64
		  	let formData = new FormData();
		  	formData.append("desc",content);

		  	let liImage = document.querySelectorAll('li');
		  	liImage.forEach(function(imgElem, index){
		  	var img = imgElem.querySelector('img');
		  	var src = img.getAttribute("src"); // data:image/png;base64 이미지 파일
		  	var base64Data = src.split(',')[1]; // data:image/png;base64, 부분 제거
		  	var blob = b64toBlob(base64Data, 'image/png');
		  	var filename = 'image_' + index + '.png';
		  	formData.append("file", blob, filename);
		  	});

		  	console.log(formData.getAll("file"));
		  	$.ajax({
		  	url: "./uploadAjax.do",
		  	type: "post",
		  	async: false,
		  	data: formData,
		  	contentType:false,
		  	processData: false,
		  	dataType: "json",
		  	success:function(msg){
		  	console.log(typeof msg, msg)
		  	if(msg.isc == "true"){
		  	alert("작성완료");
		  	}
		  	},
		  	error:function(request, error, status){
		  	console.log(request, error)
		  	}
		  	});
		  	}




		  	// Base64 문자열을 Blob 객체로 변환하는 함수
		  	function b64toBlob(b64Data, contentType) {
		  	contentType = contentType || '';
		  	var sliceSize = 512;
		  	var byteCharacters = atob(b64Data);
		  	var byteArrays = [];

		  			 	    for (var offset = 0; offset < byteCharacters.length; offset += sliceSize) {var slice = byteCharacters.slice(offset, offset + sliceSize);

		  			 	        var byteNumbers = new Array(slice.length);for (var i = 0; i < slice.length; i++) {
		  	byteNumbers[i] = slice.charCodeAt(i);
		  	}

		  			 	        var byteArray = new Uint8Array(byteNumbers);byteArrays.push(byteArray);
		  	}

		  			 	    return new Blob(byteArrays, { type: contentType });}
		  	
		  	}
		  	
		  
		  </script>
	  </div>
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
</body>
</html>