<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
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
   <li><a href='/dbms/admin/addproduct'>Add Products</a></li>
   <li>	<a href="/dbms/admin/allproducts">Manage Products</a></li>
   <li ><a href="/dbms/admin/allworkers">Workers</a></li>
    <li style="float:right"><a href="<c:url value="/j_spring_security_logout" />"> Logout</a></li>
  <li class="active" style="float:right"><a href="/dbms/admin/orders">Orders</a></li>
   <li  style="float:right"><a href="/dbms/admin/customers">Customers</a></li>

</ul>
</div>
	<center><h2> ${user}'s ORDERS</h2></center>
	
	<c:if test="${message != 'NO ORDERS PLACED!'}" >
	<br><br>
		<div class="w3-container">
	
			<table class="w3-table-all w3-card-4" align="center" >
				<tr>
      				<th>ORDER ID</th>
      				<th>ORDER DATE</th>
      				<th>ORDER TIME</th>
      				<th>STATUS</th>
      				<th>GRAND TOTAL</th>
      				<th></th>
    			</tr>
			<c:forEach items="${userorders}" var="order">
		    	<tr>      
		    	
			        <td>${order.order_id}</td>
			        <td>${order.orderdate}</td>
			        <td>${order.ordertime} </td>
			        <td>${order.status}</td>
			        <td>${order.grand_total}</td>
					
			        
			        <td> <a href = "/dbms/admin/orders/${order.order_id}">ORDER SUMMARY </a></td>
		   		</tr>
		</c:forEach>
	
		</table>
		</div>	
		</c:if>
		
		<c:if test="${message == 'NO ORDERS PLACED!'}" >
		
			<h2><center>${message}</center></h2>
		</c:if>
	<br>
			
</body>
</html>