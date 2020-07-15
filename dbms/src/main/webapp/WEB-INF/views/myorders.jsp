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
   <li ><a href='dashboard'>Dashboard</a></li>
   <li ><a href='/dbms/allproducts'>Store</a></li>
   <li style="float:right"><a href="<c:url value="/j_spring_security_logout" />"> Logout</a></li>
    <li  style="float:right"><a href='/dbms/profile'>User Profile </a></li>
   <li class="active" style="float:right"><a href='/dbms/myorders'>My Orders</a></li>
   <li  style="float:right"><a href='/dbms/myproducts'>My Cart</a></li>  
</ul>
</div>
<br>
	<center><h3>ORDER HISTORY</h3>
	</center>
	<BR>
	<BR>
	
<div class="w3-container">
	
			<table class="w3-table-all w3-card-4" align="center" >
				<tr>
      				<th>ORDER ID</th>
      				<th>DATE</th>
      				<th>TIME</th>
      				<th>STATUS</th>
      				<th>GRAND TOTAL</th>
      				<th></th>
    			</tr>
	
	
	
		<c:forEach items="${orders}" var="order">
		    <tr>      
		    	
		        <td>${order.order_id}</td>
		        <td>${order.orderdate}</td>
		        <td>${order.ordertime}</td>
		        
		        <td>${order.status}</td>
		        <td>${order.grand_total}</td>
		        
				<td> <a href = "/dbms/myorders/${order.order_id}">ORDER SUMMARY </a></td>		    
			</tr>
		</c:forEach>
	</table>
	</div>



		
	<br>
	
		
</body>
</html>