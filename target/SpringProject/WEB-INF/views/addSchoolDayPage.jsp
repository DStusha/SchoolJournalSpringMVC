<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>AddSchoolDay</title>
	<link rel="stylesheet" href="/resources/css/addStyle.css" type="text/css">
</head>
<body>
<div class="fon">
	<div class="main">
		<div class="head">
			<h1>Составить расписание</h1>
		</div>
		<div class="content">
			<form method="POST" name ="homework"action="addSchoolDay">
				<p>Выберите день недели и класс</p>
				<select class = "day" name="day">
					<option disabled>Выберите день недели</option>
						<option value="Понедельник">Понедельник</option>
						<option value="Вторник">Вторник</option>
						<option value="Среда">Среда</option>
						<option value="Четверг">Четверг</option>
						<option value="Пятница">Пятница</option>
						<option value="Суббота">Суббота</option>
					</select>
					<select class = "class" name="studClass">
						<option disabled>Выберите класс</option>
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
				<table>
					<thead>
					<tr>
						<th></th>
						<th>Предмет</th>
						<th>Домашнее задание</th>
					</tr>
					</thead>
					<tbody>
						<tr>
							<td><b>1</b></td>
							<td><select name="firstlesson">
									<option disabled>Выберите предмет</option>
									<option value="Математика">Математика</option>
									<option value="Русский язык">Русский язык</option>
									<option value="Литература">Литература</option>
									<option value="Физика">Физика</option>
									<option value="Химия">Химия</option>
									<option value="История">История</option></select></td>
							<td><input class ="homework" type="text" name = "firstHomework"/></td>
						</tr>
						<tr>
							<td>2</td>
							<td><select name="secondlesson">
									<option disabled>Выберите предмет</option>
									<option value="Математика">Математика</option>
									<option value="Русский язык">Русский язык</option>
									<option value="Литература">Литература</option>
									<option value="Физика">Физика</option>
									<option value="Химия">Химия</option>
									<option value="История">История</option></select></td>
							<td><input class ="homework" type="text" name = "secondHomework"/></td>
						</tr>
						<tr>
							<td>3</td>
							<td><select name="thirdlesson">
									<option disabled>Выберите предмет</option>
									<option value="Математика">Математика</option>
									<option value="Русский язык">Русский язык</option>
									<option value="Литература">Литература</option>
									<option value="Физика">Физика</option>
									<option value="Химия">Химия</option>
									<option value="История">История</option></select></td>
							<td><input class ="homework" type="text" name = "thirdHomework"/></td>
						</tr>
						<tr>
							<td>4</td>
							<td><select name="fourthlesson">
									<option disabled>Выберите предмет</option>
									<option value="Математика">Математика</option>
									<option value="Русский язык">Русский язык</option>
									<option value="Литература">Литература</option>
									<option value="Физика">Физика</option>
									<option value="Химия">Химия</option>
									<option value="История">История</option></select></td>
							<td><input class ="homework" type="text" name = "fourthHomework"/></td>
						</tr>
						<tr>
							<td>5</td>
							<td><select name="fifthlesson">
									<option disabled>Выберите предмет</option>
									<option value="Математика">Математика</option>
									<option value="Русский язык">Русский язык</option>
									<option value="Литература">Литература</option>
									<option value="Физика">Физика</option>
									<option value="Химия">Химия</option>
									<option value="История">История</option></select></td>
							<td><input class ="homework" type="text" name = "fifthHomework"/></td>
						</tr>
						<tr>
							<td>6</td>
							<td><select name="sixthlesson">
									<option disabled>Выберите предмет</option>
									<option value="Математика">Математика</option>
									<option value="Русский язык">Русский язык</option>
									<option value="Литература">Литература</option>
									<option value="Физика">Физика</option>
									<option value="Химия">Химия</option>
									<option value="История">История</option></select></td>
							<td><input class ="homework" type="text" name = "sixthHomework"/></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" name = "addDay" value="Сохранить" />
			</form>
		</div>
	</div>
</div>
</body>
</html>
