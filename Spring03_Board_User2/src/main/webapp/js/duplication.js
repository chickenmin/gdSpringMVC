/**
 * 
 */
 window.onload = function(){
	document.getElementById("btnUse").style.display="none";
}

function checkId1(){
	var id = document.getElementById("id").value;
	
	if(id != ""){
		$.ajax({
			url : "./duplicationAjax.do",
			type:"post",
			data:"checkId="+id,
			dataType:"json",
			async:true,
			success:function(msg){
				if(msg.isc == "true"){
					document.getElementById("condition").textContent="사용 가능한 아이디 입니다.";
					document.getElementById("btnUse").style.display = "block";
				}else{
					document.getElementById("condition").textContent="사용할 수 없는 아이디 입니다.";
					document.getElementById("btnUse").style.display = "none";
				}
			},
			error:function(){
				alert("잘못된 요청처리");
			}
		});
	}else{
		alert("아이디를 입력해주세요");
	}
}

function checkId2(){
	var id = document.getElementById("id").value;
	fetch("./duplicationFetch.do",{
		method="post",
		headers : {
			"Content-Type":'application/x-www-form-urlencoded'
		},
		body : "checkId="+id
	})
	.then(response => {
		if(!response.ok){
			throw new Error("잘못된 요청처리");
		}
		return response.text();
	})
}























