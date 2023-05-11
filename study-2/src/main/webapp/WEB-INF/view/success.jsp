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

<h1>영화 검색</h1>

<br>
<h3>Movies</h3>

</body>

<script>
const url = "https://api.themoviedb.org/3/search/movie?api_key=6a97a5c35f6fafb1f16fa0aed98bb804&language=ko-KR&query=범죄도시"

var request = new XMLHttpRequest();
		
$(function(){
	request.open('get', url);
	request.send();
	request.onload = function(){
		console.log(JSON.parse(request.response));
	}
})
</script>
</html>