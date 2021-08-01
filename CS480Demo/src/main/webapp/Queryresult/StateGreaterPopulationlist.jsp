<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center">State Population Greater Than Country AvgPopulation</h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>country_name</th>
		<th>state_name</th>
		<th>population</th>
	</tr>
<c:forEach items="${StateGreaterPopulationList}" var="complex4">
	<tr>
		<td>${complex4.countryName }</td>
		<td>${complex4.stateName }</td>
		<td>${complex4.population }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>