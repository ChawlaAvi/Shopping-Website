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
<br>
	<c:if test="${yes == 'yes'}" >
		<h3><center>PRODUCT(S) OUT OF STOCK!!</center></h3>
		
		<center>
		<a href="/dbms/allproducts">
		<button class="button button1">SHOP
		</button>
		
	</a>
	
	<a href="/dbms/myproducts">
		<button class="button button1">GO TO CART
		</button>
	</a>
	</center>
	
	</c:if>
	
	<c:if test="${yes != 'yes'}" >
	
	<h3><center>REVIEW ORDER</center></h3>
	
		<div class="w3-container">
	
			<table class="w3-table-all w3-card-4" align="center" >
				<tr>
      				<th>PRODUCT NAME</th>
      				<th>PACKET SIZE</th>
      				<th>QUANTITY</th>
      				
      				<th>STATUS</th>
      				<th>PRICE</th>
      				
    			</tr>
	
	
	
		<c:forEach items="${cartproducts}" var="product">
		    <tr>      
		    	
		        <td><a href="/dbms/allproducts/${product.getProduct().product_id}">${product.getProduct().product_name}</a></td>
		        <td>${product.packet_size}</td>
		        <td>${product.quantity}</td>
		        
		        <td>${product.available}</td>
		        <td>${product.price}</td>
		        
		    </tr>
		</c:forEach>
		<tr>  
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>	
		<tr>  
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>  
			<td></td>
			<td></td>
			<td></td>
			<td>${string}</td>
			<td>${sum}</td>
		</tr>		
	</table>
	</div>
	<br>
	
	<center>	
	<a href="/dbms/confirmed">
		<button class="button button1">PLACE ORDER
		</button>
	</a>
	
	<a href="/dbms/myproducts">
		<button class="button button1">GO TO CART
		</button>
	</a>
	<a href="/dbms/allproducts">
		<button class="button button1">SHOP MORE
		</button>
	</a>
	</center>
	</c:if>
</body>
</html>