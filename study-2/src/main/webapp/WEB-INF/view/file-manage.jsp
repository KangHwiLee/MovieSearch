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
<p>-------------------- ���ϵ�� ------------------</p>
<!-- <form action="/guest/file-upload" method="post" enctype="multipart/form-data"> -->
<p>������ �������ּ��� </p>
<input type="file" name="file">
<br>
<input type="text" name="phone" placeholder="�ڵ�����ȣ�� -�����Է����ּ���">
<br>
<button type="button" onclick="file_upload()"> ��� </button>
<p id="percent"></p>
<!-- </form> -->
<p>----------------------------------------------</p>
</div>
<br><br>
<div>
<p>-------------------- ����Ȯ�� ------------------</p>
<input type="text" name="phone2" placeholder="�ڵ�����ȣ�� -���� �Է����ּ���">
<button type="button" onclick="check()">Ȯ���ϱ�</button>
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
	  	// ���� �Ұ�
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
		alert("�ڵ�����ȣ�� Ȯ�����ּ���")
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
				view+="<li><span>"+a+"</span><button type='button' onclick='file_download(this)'>�ٿ�ε�</button></li>"
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