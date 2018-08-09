<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored ="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>ViewJournalPage</title>
	<link rel="stylesheet" href="/resources/css/style.css" type="text/css">
</head>
<body>
<%
    String type = request.getAttribute("type").toString();
	int i = 0;
%>
<div class="fon">
	<div class="main">
		<div class="head">
			<form method="POST" action="view?type=<c:out value="${type}"/>">
					<select class="day" name="day">
						<option >День недели</option>
						<option value="Понедельник">Понедельник</option>
						<option value="Вторник">Вторник</option>
						<option value="Среда">Среда</option>
						<option value="Четверг">Четверг</option>
						<option value="Пятница">Пятница</option>
						<option value="Суббота">Суббота</option>
					</select>
					<select class="class" name="studClass">
						<option>Класс</option>
						<option value="1">1 класс</option>
						<option value="2">2 класс</option>
						<option value="3">3 класс</option>
						<option value="4">4 класс</option>
						<option value="5">5 класс</option>
						<option value="6">6 класс</option>
						<option value="7">7 класс</option>
						<option value="8">8 класс</option>
						<option value="9">9 класс</option>
						<option value="10">10 класс</option>
						<option value="11">11 класс</option>
					</select>
				<input class="view" type="submit" name = "view" value="Показать"/>
			</form>
			<form method="POST" action="tomain?type=<c:out value="${type}"/>">
				<input class="home" type="submit" name = "home" value="На главную"/>
			</form>
		</div>
		<div class="content">
			<c:if test = "${schoolday !=null}">
			<p><c:out value="${day}" /></p>
			<p><c:out value="${cl}" /> класс</p>
			<table>
				<thead>
				<tr>
					<th>№</th>
					<th>Предмет</th>
					<th>Домашнее задание</th>
					<th>Оценка</th>
					<th>Действие</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach items="${schoolday}" var="sday">
					<tr>
						<td><%=++i%></td>
						<td><c:out value="${sday.name}" /></td>
						<td><c:out value="${sday.homework}" /></td>
						<td><c:out value="${sday.mark}" /></td>
						<%
							if (type.equalsIgnoreCase("student")){
						%>
						<td><a href="edit?action=homework&studClass=<c:out value="${cl}" />&week=<c:out value="${day}" />&subjId=<c:out value="${sday.id}"/>&value=<c:out value="${sday.homework}"/>">Изменить <br>домашнее задание</a></td>
						<%
							}else{
						%>
							<td><a href="edit?action=mark&studClass=<c:out value="${cl}" />&week=<c:out value="${day}" />&subjId=<c:out value="${sday.id}"/>&value=<c:out value="${sday.mark}"/>">Изменить <br>оценку</a></td>
						<%
							}
						%>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			</c:if>
		</div>
	</div>
</div>
</body>
</html>