<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css?ver=1" type="text/css">

<title>Todo</title>
</head>
<body>


<div class="tem">
	<div class="center">
		<h2>할일 등록</h2>
		<form method="POST" action="add">
			<p>어떤일인가요?</p>
			<input type="text" name="title" placeholder="swift공부하기(24자까지)" style="width : 200px">

			<p>누가 할일인가요?</p>
			<input type="text" name="name" placeholder="홍길동">

			<p>우선순위를 선택하세요</p>
			<input type="radio" id="1순위" name="sequence" value="1"> <label>1순위</label>
			<input type="radio" id="2순위" name="sequence" value="2"> <label>2순위</label>
			<input type="radio" id="3순위" name="sequence" value="3"> <label>3순위</label>
			<br>

		
		<div class="sub">
			<a href="main"> &lt이전</a>
			<input class="button1" type="submit" value="전송"> 
			<input class="button1" type="reset" value="내용 지우기">
		</div>	
	</form>



	</div>
</div>

</body>
</html>