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
<form action="/guest/file-upload" method="post" enctype="multipart/form-data">
<p>������ �������ּ��� </p>
<input type="file" name="file">
<br>
<input type="text" name="phone" placeholder="�ڵ�����ȣ�� �Է����ּ���">
<br>
<button type="submit"> ��� </button>
</form>
<p>----------------------------------------------</p>
</div>
<br><br>
<div>
<p>-------------------- ����Ȯ�� ------------------</p>
<input type="text" name="phone" placeholder="�ڵ�����ȣ�� �Է����ּ���">
<button type="button">Ȯ���ϱ�</button>
<p>----------------------------------------------</p>
</div>
</body>

</html>