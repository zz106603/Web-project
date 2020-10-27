<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.connect.jdbc.TodoDto"%>

<%
	List<TodoDto> list = (List<TodoDto>) request.getAttribute("todolist");
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

			<!-- type이 "TODO"인 것만  -->
			<section id="todo">
				<div class="todo-head">
					<h2>TODO</h2>
				</div>
				<c:forEach var="todo" items="${list}">
					<c:if test="${todo.type eq 'TODO' }">
						<div class="value-box">
							<h2 class="title-margin">${todo.title }</h2>
							<br> 등록날짜:
							${todo.regdate }
							,
							${todo.name }
							, 우선순위
							${todo.sequence }
							<br>
							${todo.type }
							<button id="${todo.id }#${todo.type}" class="move" onclick="next(id)">-></button>
						</div>
					</c:if>
				</c:forEach>
			</section>

			<!-- type이 "DOING"인 것만  -->
			<section id="doing">
				<div class="doing-head">
					<h2>DOING</h2>
				</div>
				<c:forEach var="doing" items=${list }>
					<c:if test="${doing.type eq 'DOING' }">
						<div class="value-box">
							<h2 class="title-margin">${doing.title }</h2>
							<br> 등록날짜:
							${doing.regdate }
							,
							${doing.name }
							, 우선순위
							${doing.sequence }
							<br>
							${doing.type }
							<button id="${doing.id }#${doing.type}" class="move" onclick="next(id)">-></button>
						</div>
					</c:if>
				</c:forEach>
			</section>

			<!-- type이 "DONE"인 것만  -->
			<section id="done">
				<div class="done-head">
					<h2>DONE</h2>
				</div>
				<c:forEach var="done" items=${list }>
					<c:if test="${done.type eq 'DONE' }">
						<div class="value-box">
							<h2 class="title-margin">${done.title }</h2>
							<br> 등록날짜:
							${done.regdate }
							,
							${done.name }
							, 우선순위
							${done.sequence }
							<br>
							${done.type }
							<button id="${done.id }#${done.type}" class="move" onclick="next(id)">-></button>
						</div>
					</c:if>
				</c:forEach>
			</section>

		</div>

	</div>



</body>
<script type="text/javascript" src="./main.js?v=<%=System.currentTimeMillis() %>"></script>

</html>

