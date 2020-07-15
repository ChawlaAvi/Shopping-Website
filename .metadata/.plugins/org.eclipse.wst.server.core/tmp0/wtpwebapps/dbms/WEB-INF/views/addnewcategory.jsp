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
<title>${product.product_name} Categories</title>
</head>
<body>
<div id='cssmenu'>
		<ul>
   <li ><a href='/dbms/admin'>Dashboard</a></li>
   <li class="active" ><a href='/dbms/admin/addproduct'>Add Products</a></li>
   <li ><a href="/dbms/admin/allproducts">Manage Products</a></li>
   <li ><a href="/dbms/admin/allworkers">Workers</a></li>
    <li style="float:right"><a href="<c:url value="/j_spring_security_logout" />"> Logout</a></li>
  <li  style="float:right"><a href="/dbms/admin/orders">Orders</a></li>
   <li  style="float:right"><a href="/dbms/admin/customers">Customers</a></li>

</ul>
</div>
<br>
<br>
<center><h1>${product.product_name}</h1></center>
	<c:if test="${message == 'PRODUCTS'}" >
	<br>
	<div class="w3-container">
	
			<table class="w3-table-all w3-card-4" align="center" >
				<tr>
      				<th>PACKET SIZE</th>
      				<th>PRICE</th>
      				<th>QUANTITY</th>
      				<th></th>
    			</tr>
	
	
	
		<c:forEach items="${allcategories}" var="category">
		    <tr>      
		        
		        <td>${category.packet_size}</td>
		    	<td>${category.price}</td>
		    	<td>${category.quantity}</td>
		    	<td><a href="/dbms/admin/addproduct/${product.product_id}/${category.packet_size}">Add Items</a></td>
		    </tr>
		</c:forEach>
	</table>
	</div>
	
	
	</c:if>
<br>
	<center>
	<h1>Add new category</h1></center>
	<center>
	<form:form method="post" modelAttribute="category" action="/dbms/admin/addproduct/${product.product_id}/categoryadd">
		<table>
		<form:hidden path="product_id"></form:hidden>
		
		<tr><td>
		Product Size</td><td>
		<form:input path="packet_size" type="float" required="true" placeholder="In grams"/> </td><!-- bind to user.name-->
		<td><form:errors path="packet_size" /></td></tr>
		<tr><td>
		Product Price</td><td>
		<form:input path="price" type="float" required="true" placeholder="price per unit"/> </td><!-- bind to user.name-->
		<td><form:errors path="price" /></td></tr>
		<tr><td>
		Quantity</td><td>
		<form:input path="quantity" type="number" required="true" placeholder="quantity"/> </td><!-- bind to user.name-->
		<td><form:errors path="quantity" /></td></tr>
		
			<center>	
			<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr></center>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>
	</center>
</body>
</html>



