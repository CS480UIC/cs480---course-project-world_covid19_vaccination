<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Country Insert</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Country Insert</h1>
  <%--
  1. 显示errors --> 字段错误
  2. 显示异常错误
  3. 回显
   --%>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/CountryServletInsert'/>" method="post">
	<input type="hidden" name="method" value="Country Insert"/>
	CountryName	：<input type="text" name="CountryName" value="${form.CountryName }"/>
	<span style="color: red; font-weight: 900">${errors.CountryName }</span>
	<br/>
	CountryAbbreviation	：<input type="text" name="CountryAbbreviation" value="${form.CountryAbbreviation }"/>
	<span style="color: red; font-weight: 900">${errors.CountryAbbreviation }</span>
	<br/>
	VaccineType	：<input type="text" name="VaccineType" value="${form.VaccineType }"/>
	<span style="color: red; font-weight: 900">${errors.VaccineType }</span>
	<input type="submit" value="Vaccine Insert"/>
</form>
  </body>
</html>
