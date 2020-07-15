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
   <li ><a href='/dbms/admin/addproduct'>Add Products</a></li>
   <li class="active">	<a href="/dbms/admin/allproducts">Manage Products</a></li>
   <li ><a href="/dbms/admin/allworkers">Workers</a></li>
    <li style="float:right"><a href="<c:url value="/j_spring_security_logout" />"> Logout</a></li>
  <li style="float:right"><a href="/dbms/admin/orders">Orders</a></li>
   <li style="float:right"><a href="/dbms/admin/customers">Customers</a></li>

</ul>
</div>
	<c:if test="${message == 'PRODUCTS'}" >
	<center><h2>STORE</h2></center>
	<br><br>
		<div class="w3-container">
	
			<table class="w3-table-all w3-card-4" align="center" >
				<tr>
      				<th>PRODUCT ID</th>
      				<th>PRODUCT NAME</th>
      				<th></th>
      				
    			</tr>
		
		
				<c:forEach items="${allproducts}" var="product">
		    		<tr>      
		    			<td>${product.product_id}</a></td>
		        		<td>${product.product_name}</a></td>
		    			<td><a href="/dbms/admin/allproducts/${product.product_id}">Manage Product</a></td>
		    		
		    		</tr>
		    		
				</c:forEach>
		</table>
		</div>

	</c:if>
	
	<c:if test="${message == 'NOPRODUCTS'}" >
	
		<center><H2>NO PRODUCTS IN THE STORE!</H2></center>
		<center>
			<a href="/dbms/admin/addnewproductname">
			<button class="button button1">ADD NEW PRODUCT</button>
			</a>
		</center>	
	
	</c:if>

	
	
</body>
</html>