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
   <li ><a href='/dbms/admin/addproduct'>Add Products</a></li>
   <li class="active"><a href="/dbms/admin/allproducts">Manage Products</a></li>
   <li ><a href="/dbms/admin/allworkers">Workers</a></li>
    <li style="float:right"><a href="<c:url value="/j_spring_security_logout" />"> Logout</a></li>
  <li style="float:right"><a href="/dbms/admin/orders">Orders</a></li>
   <li  style="float:right"><a href="/dbms/admin/customers">Customers</a></li>

</ul>
</div>
<c:if test="${message == 'PRODUCTS'}" >
	<center><h2>${product.product_name}'s ITEMS</h2></center>
	<br><br>
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
		    <c:if test="${done != 'yes'}" >	
		    	<c:if test="${pack != category.packet_size}" >
		    	<td><a href="/dbms/admin/allproducts/${product.product_id}/${category.packet_size}/remove">REMOVE</a></td>
		    	</c:if>
		    	
		    	<c:if test="${pack == category.packet_size}" >
		    		<c:if test="${showcat != 'yes'}" >
		    		<td><a href="/dbms/admin/allproducts/${product.product_id}/${category.packet_size}/remove">REMOVE</a></td>
		    		</c:if>
		    	
		    		<c:if test="${showcat == 'yes'}" >
		    		<td>Remove? <a href="/dbms/admin/allproducts/${product.product_id}/${category.packet_size}/removeyes">YES</a> ---- <a href="/dbms/admin/allproducts/${product.product_id}">NO</td> </td>
		    	
		    		</c:if>
		    	</c:if>
		    </c:if>
		     <c:if test="${done == 'yes'}" >
		    	<td><a href="/dbms/admin/allproducts/${product.product_id}/${category.packet_size}/remove">REMOVE</a></td>
		    
		    </c:if>
		    </tr>
		</c:forEach>
	</table>
	</div>
	
	
	</c:if>
	<c:if test="${message == 'NOPRODUCTS'}" >
	<center><H2>NO CATEGORY AVAILABLE FOR THIS PRODUCT</H2></center>
	</c:if>
	<br><br>
	
	
	<c:if test="${show != 'yes'}" >
	<center>
	<a href = "/dbms/admin/allproducts/${product.product_id}/remove">
		<button class="button button1">REMOVE PRODUCT
		</button>
	</a>
	</center>
	</c:if>
	<c:if test="${show == 'yes'}" >
	<center>
	<h2>Are you sure you want to delete the product?</h2>
	
	<a href = "/dbms/admin/allproducts/${product.product_id}/removeyes">
		<button class="button button1">YES
		</button>
	</a>
	<a href = "/dbms/admin/allproducts/${product.product_id}">
		<button class="button button1">NO
		</button>
	</a>
	</center>
	</c:if>
	
	
	
</body>
</html>