<!--<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored ="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<html>
<head>
    <meta charset="UTF-8">
    <title>MainPage</title>
	<link rel="stylesheet" href="/resources/css/startPageStyle.css" type="text/css">
</head>
<body>
<%
	String type = request.getAttribute("type").toString();
%>
<div class="fon">
	<div class="main">
		<div class="head">
			<div class="logo"></div>
			<h1>Добро пожаловать в электронный дневник!</h1>
		</div>
		<div class="content">
			<%
				if (type.equalsIgnoreCase("student")){
			%>
			<a href="view?type=<c:out value="${type}" />" class="button1" >Просмотреть расписание</a>
			<a href="addSchoolDay" class="button2" >Составить расписание</a>
			<%
				}else{
			%>
			<a href="view?type=<c:out value="${type}" />" class="button4" >Просмотреть расписание</a>
			<%
				}
			%>
			<a href="welcome" class="button3"  >Выход</a>
		</div>
	</div>
</div>
</body>
</html>