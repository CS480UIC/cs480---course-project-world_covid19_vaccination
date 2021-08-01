<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center">People Age Greater Than AvgAge</h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>city</th>
		<th>hospital_name</th>
		<th>name</th>
		<th>ID</th>
		<th>date_of_birth</th>
	</tr>
<c:forEach items="${PeopleGreaterAgeList}" var="complex5">
	<tr>
		<td>${complex5.city }</td>
		<td>${complex5.hospitalName }</td>
		<td>${complex5.name }</td>
		<td>${complex5.ID }</td>
		<td>${complex5.dateOfBirth }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>