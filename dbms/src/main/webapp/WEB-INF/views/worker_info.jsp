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
<title>Categories</title>
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
<body>
<BR>
	<center>
	
		<H2>WORKER INFO</H2><br>
		<H3>${message}</H3>
	
	</center>
	<br><br>
	
		<div class="w3-container">
	
			<table class="w3-table-all w3-card-4" align="center" >
				<tr>
      				<th>WORKER ID</th>
      				<th>NAME</th>
      				<th>ADDRESS</th>
      				<th>EMAIL</th>
      				<th>SEX</th>
      				<th>AADHAR NO</th>
      				<th>SALARY</th>
      				<th>ACCOUNT NO</th>
      				<th>BANK</th>
      				<th>IFSC</th>
      				<th>STATUS</th>
      				
    			</tr>
    	<tr>		
    			
		<td>${worker_id}</td>
		<td>${worker.name}</td>
		<td>${worker.address}</td>
		<td>${worker.email}</td>
		<td>${worker.sex}</td>
		<td>${worker.aadhar_number}</td>
		<td>${worker.salary}</td>
		<td>${worker.account_no}</td>
		<td>${worker.bank_name}</td>
		<td>${worker.IFSC}</td>
		<td>${worker.status}</td>
		
		</tr>
		</table>
		</div>
		<br>
		<center>
		<c:if test="${message != 'WORKER HAS BEEN REMOVED!!'}" >
		<c:if test="${check != 'yes'}" >
			<a href="/dbms/admin/allworkers">
				<button class="button button1">All Workers</button>
			</a>
		
			<a href="/dbms/admin/allworkers/${worker_id}/remove">
				<button class="button button1">Remove Worker</button>
			</a>
		</c:if>
		<c:if test="${check == 'yes'}" >
				
			<h3>Are you sure you want to remove the Worker?</h3>
			
		
			<a href="/dbms/admin/allworkers/${worker_id}/removeyes">
				<button class="button button1">YES</button>
			</a>
			
			<a href="/dbms/admin/allworkers">
				<button class="button button1">GO BACK</button>
			</a>
		
		
		</c:if>
		</c:if>
		<c:if test="${message == 'WORKER HAS BEEN REMOVED!!'}" >
		<a href="/dbms/admin/allworkers">
				<button class="button button1">All Workers</button>
			</a>
		
		</c:if>
		
		
		</center>
	<br>
</body>
</html>