<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
	<h3>Profile Details</h3>
	<table>   
		 <tr>
		 	<td>USERNAME : ${userinfo.username}</td>
		 </tr>
		 <tr>
		 	<td>NAME : ${userinfo.name}</td>
		 </tr>
		 <tr>
		 	<td>EMAILID : ${userinfo.mail}</td>
		 </tr>
		 <tr>
		 	<td>ADDRESS : ${userinfo.address}</td>
		 </tr>
		 <tr>
		 	<td>PHONE NUMBER : ${userinfo.phone_number}</td>
		 </tr>
		 <tr>
		 	<td>SEX : ${userinfo.sex}</td>
		 </tr>
		 <tr>
		 	<td>AADHAR NUMBER : ${userinfo.aadhar_number}</td>
		 </tr>
	</table>
	<br>
	<a href="/dbms/dashboard">Dashboard</a>
</body>
</html>