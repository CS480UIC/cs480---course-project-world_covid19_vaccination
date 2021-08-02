<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> vaccine Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>name</th>
		<th>type</th>
		<th>company</th>
		<th>protection_rate</th>
	</tr>
<c:forEach items="${VaccineList}" var="vaccine">
	<tr>
		<td>${vaccine.name }</td>
		<td>${vaccine.type }</td>
		<td>${vaccine.company }</td>
		<td>${vaccine.protectionRate }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>