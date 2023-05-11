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

<form method="post" action="/login">
<span> ID : </span>
<input type="text" name="username">
<br>
<span>pw : </span>
<input type="password" name="password">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<button type="submit" form="login" onclick="test()">로그인</button>
</form>

</body>
<script>
function test(){
	console.log("click")
	$("form").submit();
}
</script>
</html>