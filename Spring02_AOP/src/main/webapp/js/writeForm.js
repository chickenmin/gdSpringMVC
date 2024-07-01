
let isCtrl = false; // ctrl키의 조합키 판달을 위한 값
let isShow = true; // submit은 페이지 벗어남 오류 알림

window.onbeforeunload = function() {arguments
	if(isShow){
		return "화면에서 벗어 납니다";
	}

}



document.addEventListener("keydown", function(e) {
	if (e.keyCode === 17) {
		isCtrl = true;
	}
	if ((e.keyCode === 116) || (e.keyCode === 82 && isCtrl) || (e.keyCode === 78 && isCtrl)) {
		e.preventDefault();
		//e.stopPropagation();
		//return false;
		console.log(e.keyCode === 116 ? "F5" : (e.keyCode === 82 ? "Ctrl + R" : "Ctrl + N"));
	}

	});

	document.addEventListener("keyup", function(e) {
		if (e.keyCode === 17) {
			isCtrl = false;
		}
	});
	
	function validateForm(){
		console.log("유효성 검사 : XXS 처리	")
		var form = document.forms[0];
		
		var title = document.getElementById("id");
		var content = document.getElementById("content");
		
		console.log(title.value , content.value);
		
		if(title.value == "" || content.value == ""){
			alert("필수값 입력");
		}else{
			isShow =false;
			
			var str = content.value;
			str = str.replace(/\r\n|\r|\n|\n\r/gim, "<br>");
			str = str.replace(/</gim, "&lt;");
			str = str.replace(/>/gim,"&gt;");
			str = str.replace(/\'/gim, "&#39");
			document.getElementById("converView").innerHTML = str;
			
			content.value = str;
			
			form.submit();
		}
	}
	
	
	
	
	
	
	
	
	