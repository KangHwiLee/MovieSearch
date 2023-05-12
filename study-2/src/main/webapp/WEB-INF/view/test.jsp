<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="/js/jquery-3.6.0.min.js"></script>
<style>
#list > div{display: inline-block; padding:20px}
#list > div > img{width:200px;}
</style>
</head>
<body>

<h1>��ȭ �˻�</h1>

<br>

<input type="text" id="search"/>

<br>
<h3>Movies</h3>
<div id="area">
	<div id="list">
		<div>
			<img src="https://image.tmdb.org/t/p/w500/xoqr4dMbRJnzuhsWDF3XNHQwJ9x.jpg">
			<p>��ȭ����</p>
			<p>��ȭ ����</p>
			<p>��ȭ ����</p>
		</div>
		<div>
			<p>��ȭ����</p>
			<p>��ȭ ����</p>
			<p>��ȭ ����</p>
		</div>
	</div>
</div>
</body>
<script>

function search(){
	var obj = {"keyword" : $("#search").val()}
	console.log(obj)
	$.ajax({
		url : "/guest/movies",
		type : "post",
		data : JSON.stringify(obj),
		contentType : "application/json",
		dataType : "json",
		success : function(data){
				view = "";
			data.forEach((a,index) => {
					//view += (index+1)%5==0 ? "<div id='list'>" : ""
					view += "<div>"
					view += "<img src='https://image.tmdb.org/t/p/w500/"+a.poster_path+"'>"
					view += "<p>"+a.title+"</p>"
					view += "<p>"+a.vote_average+"</p>"
					view += "<p>"+a.overview+"</p>"
					view += "</div>"
					//view += (index+1)%5==0 ? "</div>" : ""
			});
			$("#area").html(view);
		}
	})
}

let timer = null;
$('#search').keyup(function() {
  clearTimeout(timer); // ������ ������ Ÿ�̸� ����
  timer = setTimeout(function() {
     search(1);
  }, 1000); // 0.5�� �� page_move() �Լ� ȣ��
});

</script>
</html>