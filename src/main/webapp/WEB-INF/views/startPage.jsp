<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored ="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<meta charset="UTF-8">
	<title>HelloPage</title>
	<link rel="stylesheet" href="/resources/css/startPageStyle.css" type="text/css">
</head> 
<body>
<div class="fon">
	<div class="main">
		<div class="head">
			<div class="logo"></div>
			<h1>Добро пожаловать в электронный дневник!</h1>
		</div>
		<div class="content">
			<div class="login">
				<h1>Войти в электронный дневник</h1>
				<form method="post" action="check-user">
					<input id = "student" type="radio" checked name="usertype" value="student"/><label id="studlabel" for ="student">Режим ученика</label>
					<input id = "teacher" type="radio"  name="usertype" value="teacher"/><label id="teachlabel" for ="teacher">Режим учителя</label>
					<input type="submit" name="commit" value="Войти"/>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>