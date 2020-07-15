<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url var="css" value="/css" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${css}/styles.css" />
<link rel="stylesheet" type="text/css" href="${css}/w3.css" />
<title>CATEGORIES</title>
</head>
<body>

	<div id='cssmenu'>
		<ul>
   <li ><a href='dashboard'>Dashboard</a></li>
   <li ><a href='/dbms/allproducts'>Store</a></li>
   <li class="active"><a href='/dbms/allproducts/${category.product_id}'>${product.product_name}</a></li>
   <li style="float:right"><a href="<c:url value="/j_spring_security_logout" />"> Logout</a></li>
    <li  style="float:right"><a href='/dbms/profile'>User Profile </a></li>
   <li style="float:right"><a href='/dbms/myorders'>My Orders</a></li>
   <li style="float:right"><a href='/dbms/myproducts'>My Cart</a></li>
  
   
   
</ul>
</div>

	<h2> <center> ${product.product_name} </center></h2>
	<br><br>
	<br>
		
		<div class="w3-container">
	
			<table class="w3-table-all w3-card-4" align="center" >
				<tr>
      				<th>PACKET SIZE</th>
      				<th>PRICE PER UNIT</th>
      				<th>IN STOCK QUANTITY</th>
      				<th></th>
    			</tr>
	
		<c:forEach items="${allcategories}" var="category">
		    <tr>      
		        
		        <td>${category.packet_size} </td>
		    	<td>${category.price}</td>
		    	<td>${category.quantity}</td>
		    	<td><a href="/dbms/allproducts/${category.product_id}/${category.packet_size}/add">ADD TO CART</a></td>
		    </tr>
		</c:forEach>
	
		</table>
		</div>

</body>
</html>