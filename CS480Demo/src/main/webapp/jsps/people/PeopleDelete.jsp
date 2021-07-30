<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>People Delete</title>
    
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
  <h1>People Delete</h1>
  <%--
  1. 显示errors --> 字段错误
  2. 显示异常错误
  3. 回显
   --%>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/PeopleServletDelete'/>" method="post">
	<input type="hidden" name="method" value="People Delete"/>
	<!-- Number    :<input type="text" name="number" value="${form.number }"/>
	<span style="color: red; font-weight: 900">${errors.number }</span>
	<br/> 
	ID：<input type="text" name="ID" value="${form.ID }"/>
	<span style="color: red; font-weight: 900">${errors.ID }</span>
	<br/> 
	Name	：<input type="text" name="name" value="${form.name }"/>
	<span style="color: red; font-weight: 900">${errors.name }</span>
	<br/> -->
	Age    :<input type="text" name="age" value="${form.age }"/>
	<span style="color: red; font-weight: 900">${errors.age }</span>
	<!-- <br/>
	DateOfBirth    :<input type="text" name="date_of_birth" value="${form.date_of_birth }"/>
	<span style="color: red; font-weight: 900">${errors.date_of_birth }</span> -->
	<br/> 
	<input type="submit" value="People Delete"/>
</form>
  </body>
</html>
