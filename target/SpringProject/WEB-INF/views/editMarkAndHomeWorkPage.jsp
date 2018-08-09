<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page isELIgnored ="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit</title>
	<link rel="stylesheet" href="/resources/css/editStyle.css" type="text/css">
</head>
<body>
<div class="fon">
	<div class="main">
		<div class="head">
			<h1>Редактирование</h1>
		</div>
		<div class="content">
			<table>
				<thead>
					<tr>
						<th><c:out value="${week}" /></th>
						<th><c:out value="${cl}"/></th>
						<th><c:out value="${subject.name}" /></th>
					</tr>
				</thead>
			</table>
			<form method="POST" action="edit?id=<c:out value="${subject.id}" />&action=<c:out value="${edit}" />">
				<%
					String action = request.getAttribute("edit").toString();
					if (action.equalsIgnoreCase("mark")){
				%>
				<p top="222px"></p>Оценка:</p> <input top="220px" type="text" name="value"
							   value="<c:out value="${value}" />" />
				<input type="submit" name = "markSave" value="Сохранить" />
				<%            } else {
				%>
				<p top="225px">Домашнее задание: </p><input top="220px" type="text" name="value"
							   value="<c:out value="${value}" />" />
				<input type="submit" name = "workSave" value="Сохранить" />
				<%
					}
				%>
			</form>
		</div>
	</div>
</div>
</body>
</html>
