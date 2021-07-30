<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> people Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>number</th>
		<th>hospital_name</th>
		<th>ID</th>
		<th>name</th>
		<th>age</th>
		<th>date_of_birth</th>
	</tr>
<c:forEach items="${PeopleList}" var="people">
	<tr>
		<td>${people.number }</td>
		<td>${people.hospitalName }</td>
		<td>${people.ID }</td>
		<td>${people.name }</td>
		<td>${people.age }</td>
		<td>${people.dateOfBirth }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>