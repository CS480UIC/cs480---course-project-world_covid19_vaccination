<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> country Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>country_name</th>
		<th>country_abbreviation</th>
		<th>vaccine_type</th>
	</tr>
<c:forEach items="${OrderedAbbreviationList}" var="country">
	<tr>
		<td>${country.countryName }</td>
		<td>${country.countryAbbreviation }</td>
		<td>${country.vaccineType }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>