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
   <li ><a href='dashboard'>Dashboard</a></li>
   <li ><a href='/dbms/allproducts'>Store</a></li>
   <li style="float:right"><a href="<c:url value="/j_spring_security_logout" />"> Logout</a></li>
    <li  style="float:right"><a href='/dbms/profile'>User Profile </a></li>
   <li style="float:right"><a href='/dbms/myorders'>My Orders</a></li>
   <li class="active" style="float:right"><a href='/dbms/myproducts'>My Cart</a></li>  
</ul>
</div>

	
	<c:if test='${oops != "ORDER CANNOT BE CANCELLED NOW!!"}'>
	
	<center> 
		<h2>${message}</h2></center>
	
	</c:if>
	
	
	<c:if test='${oops == "ORDER CANNOT BE CANCELLED NOW!!"}' >
	<center><h2>${oops}</h2></center>
	</c:if>
	
	<div class="w3-container">
	
			<table class="w3-table-all w3-card-4" align="center" >
				<tr>
      				<th>ORDER ID</th>
      				<th>DATE</th>
      				<th>TIME</th>
      				<th>STATUS</th>
      				<th>GRAND TOTAL</th>
    			</tr>
    			<tr>
    				<td>${order_id}</td>
    				<td>${date}</td>
    				<td>${time}</td>
    				<td>${status}</td>
    				<td>${total}</td>
    			</tr>
		</table>
		</div>
	<br><br>
	<center> <h3>PRODUCTS</h3>
	</center>
	
	<div class="w3-container">
	
			<table class="w3-table-all w3-card-4" align="center" >
			<tr>
		    <th>PRODUCT NAME</th>
		    <th>PACKET SIZE</th>
		    <th>QUANTITY</th>
		    <th>AMOUNT</th>
		    
		    </tr>
		<c:forEach items="${order}" var="product">
		    
		    	    
		    <tr>      
		    	
		        <td>${product.getProduct().product_name}</td>
		        <td>${product.packet_size}</td>
		        <td>${product.ordered_quantity}</td>
		        <td>${product.amount}</td>
		        
		   	</tr>
		    <br>
		</c:forEach>
		
	</table>
	</div>
		<br>
		<br>
		<center>
		<a href="/dbms/allproducts">
		<button class="button button1">PLACE A NEW ORDER
		</button>
	</a>
		</center>
		
	<br>
	
        
		
</body>
</html>