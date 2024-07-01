//많이 쓰는 코드
// $(document).ready(function(){
//   console.log("JQuery onload 작동");
//   $(".navbar-nav li").click(function(){
//      //현재 클릭한 li에 active 클래스 추가
//      $(this).addClass("active").siblings().removeClass("active");
//      $(this).parent().siblings().find("li").removeClass("active");
//   });
// });

document.addEventListener("DOMContentLoaded", function() {
   console.log("javascript onload 작동");

   var menu = document.querySelectorAll(".navbar-nav li");
   menu.forEach(function(item) {
      item.addEventListener("click", function() {
         //현재 클릭한 li에 active 클래스 추가
         this.classList.add("active");
         //현재 클릭한 li를 제외한 다른 li 클래스에서 active를 제거
         menu.forEach(function(other) {
            if (other != item) {
               other.classList.remove("active");
            }
         });
      });
   });
});





//boardList.jsp 기능

//1) javascript를 통한 전체 ch의 선택과 취소
function checkAll(bool) {
   console.log("chkbox의 상태: ", bool);
   var chs = document.getElementsByName("ch");
   for (let i = 0; i < chs.length; i++) {
      chs[i].checked = bool;
   }
}


//자바스크립트는 onload 여러 개면 오버라이드돼서 하나만 동작
//제이쿼리는 여러 개여도 여러 번 동작
//2) jquery를 통한 전체 ch의 선택과 취소
/*$(function() {
   console.log("jquery checkbox function onload 확인");
   $(".allCheckBox").click(function() {
      $(".ch").prop("checked", this.checked);
   });
});*/

//3) javascript 하위 ch의 체크에 따라 allCheckBox 체크 상태 변경
//window.onload = function() {
//   console.log("javascript onload 확인");
//   var chs = document.getElementsByName("ch");
//   var chkbox = document.getElementById("chkbox");
//
//   for (let i = 0; i < chs.length; i++) {
//      chs[i].onclick=function(){
//         if(chs.length==chCheckedCount()){
//            chkbox.checked=true;
//         }else{
//            chkbox.checked=false;
//         }
//      }
//   }
//}
//
var chCheckedCount = function() {
   var chs = document.getElementsByName("ch");
   let cnt = 0;
   for (let i = 0; i < chs.length; i++) {
      if (chs[i].checked) {
         cnt++;
      }
   }
   return cnt;
}


//4) jquery 하위 ch의 체크에 따라 allCheckBox 체크 상태 변경
$(document).ready(function() {
   console.log("ch에 따른 allCheckBox 체크 상태 변경");
   var chs = $("input[name=ch]");
   var chkbox = $("#chkbox");

   chs.click(function() {
      chkbox.prop("checked", chs.filter(":checked").length === chs.length)
   });
});

//5) submit 동작제어
/*
	type =submit => onsubmit = "return submitFn()"
	
	document.forms[0].onsubmit = function(e){e.preventDefault();}
	
	document.forms[0].addEventListener("submit", function(e){e.preventEdfault()});
	
*/

//javascript submit 동작제어
function chkSubmit(){
	var cnt = chCheckedCount();
	if(cnt == 0){
		alert("선택된 글이 없습니다");	
	}else{
		submitForm();
	}
	console.log("submit 동작 fn")
	return false;
};

//6)
function chSubmit(event){
	console.log(event);
	event.preventDefault();
//	return false;
	var cnt = chCheckedCount();
	if(cnt > 0){
		Swal.fire({
			title: "다중삭제를 진행하겠습니까?",
			showDenyButton: true,
			confirmButtonText: "삭제",
			denyButtonText: `취소`
		}).then((result) => {
			if (result.isConfirmed) {
				Swal.fire("Saved!", "", "success").then(() => {
					submitForm();
				});
			} else if (result.isDenied) {
				Swal.fire("Changes are not saved", "", "info");
			}
		});
	} else {
		Swal.fire("선택된 게시글이 없습니다");
	}
	console.log("chSubmit 마지막 줄");

	
}
function submitForm(){
	document.forms[0].submit();
}


//--boardDetail.jsp

//1)관리자 삭제

function del(event){
	event.preventDefault();
	console.log();
	var frm = document.forms[0];
	
	var con = confirm("선택된 글이 삭제 됩니다");
	if(con){
		frm.action = "./realDelete.do";
		frm.method = "post";
		frm.submit();
	}else{
		alert("삭제가 취소되었습니다");
	}
}

//2) 관리자 수정
// javascript에서 화면에 있는 값을 주소에 queryString으로 만들어서 요청
function modify(event){
	event.preventDefault();
	var frm = document.forms[0];
	
	var seq = document.querySelector("input[name=seq]").value;
	
	frm.action = "./modifyBoard.do?seq="+seq;
	frm.method = "get";
	frm.submit();
}

// 3)회원 답글입력
function reply(event){
	event.preventDefault();
	var frm = document.forms[0];
	
	var seq = document.querySelector("input[name=seq]").value;
	
	frm.action = "./replyBoard.do?seq="+seq;
	frm.submit();
}
















