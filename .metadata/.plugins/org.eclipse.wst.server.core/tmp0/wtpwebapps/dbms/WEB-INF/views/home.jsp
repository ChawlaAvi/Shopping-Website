<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url var="css" value="/css" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${css}/styles.css" />
<link rel="stylesheet" type="text/css" href="${css}/w3.css" />
<title>Remove Item</title>
</head>
<body>
<div id='cssmenu'>
<ul>
   <li class="active"><a href='/dbms'>Home</a></li>
   <li><a href='/dbms/contact'>Contact</a></li>
   
   <li style="float:right"><a href='login'>Login</a></li>
   <li style="float:right"><a href='register'>Register</a></li>
   
</ul>
</div>
<br>
<center>
<BR><BR><BR><BR>
<BR><BR>
<BR><BR>

	<h1>WELCOME</h1>
	<h1>${name}</h1>
	<h1>${description}</h1>
	<br>
</center>	
	
</body>
</html>