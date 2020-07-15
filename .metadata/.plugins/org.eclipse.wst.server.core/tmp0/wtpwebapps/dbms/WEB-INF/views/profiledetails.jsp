<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url var="css" value="/css" />
<%@page session="true"%>	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" type="text/css" href="${css}/styles.css" />
<link rel="stylesheet" type="text/css" href="${css}/w3.css" />

</head>
<body>
	        <div id='cssmenu'>
		<ul>
   <li ><a href='dashboard'>Dashboard</a></li>
   <li ><a href='/dbms/allproducts'>Store</a></li>
   <li style="float:right"><a href="<c:url value="/j_spring_security_logout" />"> Logout</a></li>
    <li class="active" style="float:right"><a href='/dbms/profile'>User Profile </a></li>
   <li style="float:right"><a href='/dbms/myorders'>My Orders</a></li>
   <li style="float:right"><a href='/dbms/myproducts'>My Cart</a></li>
  
   
   
</ul>
</div>


	<h3><center>Profile Details</center></h3>
	<br>
	
	<div class="w3-container">
	
<table class="w3-table-all w3-card-4">		 
		
		<tr>
      		<th>Attribute</th>
      		<th>Detail</th>
    	</tr>
		
		<tr>
		 	<td>USERNAME</td> <td> ${userinfo.username}</td>
		 </tr>
		 <tr>
		 	<td>NAME </td> <td> ${userinfo.name}</td>
		 </tr>
		 <tr>
		 	<td>EMAILID </td> <td> ${userinfo.email}</td>
		 </tr>
		 <tr>
		 	<td>ADDRESS </td> <td> ${userinfo.address}</td>
		 </tr>
		 <tr>
		 	<td>PHONE NUMBER </td> <td> ${userinfo.phone_number}</td>
		 </tr>
		 <tr>
		 	<td>SEX  </td> <td> ${userinfo.sex}</td>
		 </tr>
		 <tr>
		 	<td>AADHAR NUMBER </td> <td>${userinfo.aadharnumber}</td>
		 </tr>
		 
	</table>
</body>
</html>