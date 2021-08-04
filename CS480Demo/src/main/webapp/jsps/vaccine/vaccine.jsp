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
	
			<a href="<c:url value='/jsps/main.jsp'/>" target="_parent">main page</a>  |&nbsp;
			<a href="<c:url value='/jsps/vaccine/VaccineInsert.jsp'/>" target="_parent">Vaccine Insert</a>  |&nbsp;
			<a href="<c:url value='/jsps/vaccine/VaccineRead.jsp'/>" target="_parent">Vaccine Read</a>  |&nbsp; 
			<a href="<c:url value='/jsps/vaccine/VaccineDelete.jsp'/>" target="_parent">Vaccine Delete</a>  |&nbsp; 
			<a href="<c:url value='/jsps/vaccine/VaccineUpdate.jsp'/>" target="_parent">Vaccine Update</a>		
</div>
  </body>
</html>
