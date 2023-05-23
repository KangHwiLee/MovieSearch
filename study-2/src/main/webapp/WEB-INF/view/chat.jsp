<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
채팅


<div>
<button>접속</button>
<button id="disconn">해제</button>
</div>

<div style="border:1px solid; width:400px; height:700px;">

</div>
<input type="text" style="width:350px;">
<button id="button-send">전송</button>
</body>

<script>
$(document).ready(function(){
	const username = "test";
	$("#disconn").on("click", (e) => {
        disconnect();
    })
    
    $("#button-send").on("click", (e) => {
        send();
    });
	
	const websocket = new WebSocket("ws://localhost:8080/ws/chat");
})
</script>

</html>