<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: #87CEFA; 
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">world_covid19_vaccination Database</h1>
<div style="font-size: 10pt;">
	
			<a href="<c:url value='/jsps/QueryResult/complex/ComplexQuery1.jsp'/>" target="_parent">Complex Query 1 (sum(), join, group by, and order by are used)  the list of countries and their population</a>  &nbsp;
			<br>
			<br>
			<a href="<c:url value='/jsps/QueryResult/complex/ComplexQuery2.jsp'/>" target="_parent">Complex Query 2 (joined 3 tables, and nested query are used)  the list of hospitals and the info of vaccine that they are using</a>  &nbsp; 
			<br>
			<br>
			<a href="<c:url value='/jsps/QueryResult/complex/ComplexQuery3.jsp'/>" target="_parent">Complex Query 3 (sum(), join, group by, and having are used)  the list of state which number of vaccinated people > 150000</a>  &nbsp; 
			<br>
			<br>
			<a href="<c:url value='/jsps/QueryResult/complex/ComplexQuery4.jsp'/>" target="_parent">Complex Query 4 (correlated nested query is used)  the list of info of states which population is > average population in its country</a>  &nbsp; 
			<br>
			<br>
			<a href="<c:url value='/jsps/QueryResult/complex/ComplexQuery5.jsp'/>" target="_parent">Complex Query 5 (join and correlated nested query are used)  the list of info of people whose age > average age of vaccinated people in the same hospital</a>
</div>
  </body>
</html>
