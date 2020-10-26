<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.connect.jdbc.TodoDto"%>

<%
	List<TodoDto> todolist = (List<TodoDto>) request.getAttribute("todolist");
	List<TodoDto> doinglist = (List<TodoDto>) request.getAttribute("doinglist");
	List<TodoDto> donelist = (List<TodoDto>) request.getAttribute("donelist");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo</title>

<link rel="stylesheet" href="css/style.css?ver=1" type="text/css">
</head>

<body>

<div class="side">
	<header>
		<form method="GET" action="write">
			<button id="button-sign">TODO 작성하기</button>
		</form>
	</header>

	<section class="title">
		<h2>나의 해야할 일들</h2>
	</section>

	<div id="table-align">
	<section id="todo">
		<div class="todo-head"><h2>TODO</h2></div>
		<c:forEach var="todolist" items="${todolist}">
			<form action="type" method="get">
				<div class="value-box">
					<h2 class="title-margin"><c:out value="${todolist.title}" /></h2>
					<br> 등록날짜:
					<c:out value="${todolist.regdate}" />
					,
					<c:out value="${todolist.name}" />
					, 우선순위
					<c:out value="${todolist.sequence}" />
					<br>
					<c:out value="${todolist.type}" />
					<input type="hidden" name="id" value="${todolist.id }"></input>
 					<input type="hidden" name="type" value="${todolist.type }"></input> 
					<button class="move">-></button>
				</div>
			</form>
		</c:forEach>
	</section>

	<section id="doing">
		<div class="doing-head"><h2>DOING</h2></div>
		<c:forEach var="doinglist" items="${doinglist}">
			<form action="type" method="get">
				<div class="value-box">
					<h2 class="title-margin"><c:out value="${doinglist.title}" /></h2>
					<br> 등록날짜:
					<c:out value="${doinglist.regdate}" />
					,
					<c:out value="${doinglist.name}" />
					, 우선순위
					<c:out value="${doinglist.sequence}" />
					<br>
					<c:out value="${doinglist.type}" />
					<input type="hidden" name="id" value="${doinglist.id }"></input>
 					<input type="hidden" name="type" value="${doinglist.type }"></input> 
					<button class="move">-></button>
				</div>
			</form>
		</c:forEach>
	</section>

	<section id="done">
		<div class="done-head"><h2>DONE</h2></div>
		<c:forEach var="donelist" items="${donelist}">
			<div class="value-box">
				<h2 class="title-margin"><c:out value="${donelist.title}" /></h2>
				<br> 등록날짜:
				<c:out value="${donelist.regdate}" />
				,
				<c:out value="${donelist.name}" />
				, 우선순위
				<c:out value="${donelist.sequence}" />
				<br>
				<c:out value="${donelist.type}" />
			</div>
		</c:forEach>
	</section>

</div>

</div>



</body>


</html>

