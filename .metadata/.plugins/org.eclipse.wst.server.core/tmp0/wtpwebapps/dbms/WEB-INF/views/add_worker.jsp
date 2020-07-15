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
<title>ADD WORKER</title>
</head>
<body>
<div id='cssmenu'>
		<ul>
   <li ><a href='/dbms/admin'>Dashboard</a></li>
   <li  ><a href='/dbms/admin/addproduct'>Add Products</a></li>
   <li ><a href="/dbms/admin/allproducts">Manage Products</a></li>
   <li class="active"><a href="/dbms/admin/allworkers">Workers</a></li>
    <li style="float:right"><a href="<c:url value="/j_spring_security_logout" />"> Logout</a></li>
  <li  style="float:right"><a href="/dbms/admin/orders">Orders</a></li>
   <li  style="float:right"><a href="/dbms/admin/customers">Customers</a></li>

</ul>
</div>
<center>
	<h2>ADD WORKER</h2>
<br><br>
	<form:form method="post" modelAttribute="worker" action="/dbms/admin/addworker">
		<table>
		
		<form:hidden path="status"></form:hidden>
		
		<tr><td>
		Name</td><td>
		<form:input path="name" type="text" required="true" placeholder="name"/> </td><!-- bind to user.name-->
		<td><form:errors path="name" /></td></tr>
		
		<tr><td>
		Sex</td><td>
		<form:input path="sex" type="text" required="true" placeholder="M/F" pattern="[M,F]{1}"/> </td><!-- bind to user.name-->
		<td><form:errors path="sex" /></td></tr>
		
		<tr><td>
		Address</td><td>
		<form:input path="address" type="text" required="true" placeholder="address"/> </td><!-- bind to user.name-->
		<td><form:errors path="address" /></td></tr>
		<tr><td>
		
		Aadhar Number</td><td>
		<form:input path="aadhar_number" type="text" required="true" placeholder="aadhar no"/> </td><!-- bind to user.name-->
		<td><form:errors path="aadhar_number" /></td></tr>
		<tr><td>
		Salary</td><td>
		<form:input path="salary" type="float" required="true" placeholder="salary"/> </td><!-- bind to user.name-->
		<td><form:errors path="salary" /></td></tr>
		<tr><td>
		Email</td><td>
		<form:input path="email" type="email" required="true" placeholder="email"/> </td><!-- bind to user.name-->
		<td><form:errors path="email" /></td></tr>
		<tr><td>
		BANK NAME</td><td>
		<form:input path="bank_name" type="text" required="true" placeholder="bank"/> </td><!-- bind to user.name-->
		<td><form:errors path="bank_name" /></td></tr>
		<tr><td>
		IFSC</td><td>
		<form:input path="IFSC" type="text" required="true" placeholder="IFSC Code" /> </td><!-- bind to user.name-->
		<td><form:errors path="IFSC" /></td></tr>
		<tr><td>
		ACCOUNT NUMBER</td><td>
		<form:input path="account_no" type="text" required="true" placeholder="account no"/> </td><!-- bind to user.name-->
		<td><form:errors path="account_no" /></td></tr>
		<tr><td>
		
		
				<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>
	<br>
	<a href="/dbms/admin/allworkers">
				<button class="button button1">ALL WORKERS</button>
			</a>
	
	</center>

	
	