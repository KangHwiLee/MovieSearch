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
<form action="/guest/file-upload" method="post" enctype="multipart/form-data">
<p>파일을 선택해주세요 </p>
<input type="file" name="file">
<br>
<input type="text" name="phone" placeholder="핸드폰번호를 입력해주세요">
<br>
<button type="submit"> 등록 </button>
</form>
<p>----------------------------------------------</p>
</div>
<br><br>
<div>
<p>-------------------- 파일확인 ------------------</p>
<input type="text" name="phone" placeholder="핸드폰번호를 입력해주세요">
<button type="button">확인하기</button>
<p>----------------------------------------------</p>
</div>
</body>

</html>