<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.connect.jdbc.TodoDto"%>


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

			<!-- type이 "TODO"인 것만  -->
			<section id="todo">
				<div class="todo-head">
					<h2>TODO</h2>
				</div>
				<c:forEach var="todo" items="${list}">
					<c:if test="${todo.getType() eq 'TODO' }">
						<div class="value-box">
							<h2 class="title-margin">${todo.getTitle() }</h2>
							<br>
							등록날짜 : ${todo.getRegdate() }, ${todo.getName() } 우선순위 : ${todo.getSequence() }
							<button id="${todo.getId()}#${todo.getType()}" class="move"	onclick="next(id)">-></button>
							<button id="${todo.getId()}#${todo.getType()}" class="move"	onclick="deleteTodo(id)">X</button>
						</div>
					</c:if>
				</c:forEach>

			</section>

			<!-- type이 "DOING"인 것만  -->
			<section id="doing">
				<div class="todo-head">
					<h2>DOING</h2>
				</div>
				<c:forEach var="doing" items="${list}">
					<c:if test="${doing.getType() eq 'DOING' }">
						<div class="value-box">
							<h2 class="title-margin">${doing.getTitle() }</h2>
							<br>
							등록날짜 : ${doing.getRegdate() }, ${doing.getName() } 우선순위 : ${doing.getSequence() }
							<button id="${doing.getId()}#${doing.getType()}}" class="move" onclick="next(id)">-></button>
							<button id="${doing.getId()}#${doing.getType()}}" class="move"	onclick="deleteTodo(id)">X</button>
						</div>
					</c:if>
				</c:forEach>
			</section>

			<!-- type이 "DONE"인 것만  -->
			<section id="done">
				<div class="todo-head">
					<h2>DONE</h2>
				</div>
				<c:forEach var="done" items="${list}">
					<c:if test="${done.getType() eq 'DONE' }">
						<div class="value-box">
							<h2 class="title-margin">${done.getTitle() }</h2>
							<br>
							등록날짜 : ${done.getRegdate() }, ${done.getName() } 우선순위 : ${done.getSequence() }
							<button id="${done.getId()}#${done.getType()}}" class="move" onclick="deleteTodo(id)">X</button>
						</div>
					</c:if>
				</c:forEach>
			</section>

		</div>

	</div>



</body>
<script type="text/javascript" src="./main.js?v=<%=System.currentTimeMillis() %>">

	
</script>

</html>

