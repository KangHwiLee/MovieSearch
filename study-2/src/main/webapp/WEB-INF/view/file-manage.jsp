<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<div>
<p>-------------------- 파일등록 ------------------</p>
<!-- <form action="/guest/file-upload" method="post" enctype="multipart/form-data"> -->
<p>파일을 선택해주세요 </p>
<input type="file" name="file">
<br>
<input type="text" name="phone" placeholder="핸드폰번호를 -빼고입력해주세요">
<br>
<button type="button" onclick="file_upload()"> 등록 </button>
<p id="percent"></p>
<!-- </form> -->
<p>----------------------------------------------</p>
</div>
<br><br>
<div>
<p>-------------------- 파일확인 ------------------</p>
<input type="text" name="phone2" placeholder="핸드폰번호를 -빼고 입력해주세요">
<button type="button" onclick="check()">확인하기</button>
<p>----------------------------------------------</p>
</div>
<div id="file_list">

</div>
</body>
<script>



function file_upload(){
 	var formData = new FormData();
	var data = $('input[name=file]')[0].files[0];
	formData.append("file", data);
	formData.append("phone", $("input[name=phone]").val())
/*	
	$.ajax({
	    type:"POST",
	    url: "/guest/file-upload",
	    processData: false,
	    contentType: false,
	    data: formData,
	    success: function(){
	    },
	    err: function(err){
	      console.log("err:", err)
	    }
	  }) */
	  
	  var xhr = new XMLHttpRequest();
	  
	xhr.upload.onload = (e) => {
		console.log('upload complete', e);
	}
	xhr.upload.onprogress = (e) => {
	  if( e.lengthComputable ) {
	    var percentComplete = Math.floor(e.loaded / e.total * 100);
	    $("#percent").text(percentComplete)
	  } else {
	  	// 측정 불가
	  }
	}
	xhr.upload.onabort = () => {
	    console.error('Upload cancelled.');
	}
	xhr.open('post', '/guest/file-upload');
	xhr.send(formData);  
	
}

function check(){
	var phone = $("input[name=phone2]").val();
	if(phone.length < 11){
		alert("핸드폰번호를 확인해주세요")
		return;
	}
	$.ajax({
		url : "/guest/file-check",
		type : "post",
		data : {"phone" : phone},
		success : function(data){
			if(data == null) return null;
			view = "<ul id="+phone+">"
			data.forEach((a, index) => {
				view+="<li><span>"+a+"</span><button type='button' onclick='file_download(this)'>다운로드</button></li>"
			})
			view += "</ul>"
			$("#file_list").html(view);
		}
	})
}

function file_download(test){
	var phone = $("ul").attr('id');
	var file_name = test.parentElement.querySelector('span').innerText
	location.href="/guest/file-download?phone="+phone+"&file_name="+file_name
	
}

</script>
</html>