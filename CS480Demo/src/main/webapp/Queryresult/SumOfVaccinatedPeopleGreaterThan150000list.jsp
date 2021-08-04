<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Sum Of Vaccinated People Greater Than 150000 Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>country_name</th>
		<th>sum_of_vaccinated_people</th>
	</tr>
<c:forEach items="${SumOfVaccinatedPeopleGreaterThan150000List}" var="complex3">
	<tr>
		<td>${complex3.countryName }</td>
		<td>${complex3.sumOfVaccinatedPeople }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>