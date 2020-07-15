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
	<center><h3>ORDER SUMMARY</h3></center>
	
	<br>
	<div class="w3-container">
		<table class="w3-table-all w3-card-4" align="center" >
				<tr>
      				<th>ORDER ID</th>
      				<th>CUSTOMER</th>
      				<th>ORDER DATE</th>
      				<th>ORDER TIME</th>
      				<th>STATUS</th>
      				<th>GRAND TOTAL</th>
    			</tr>
    			<tr>
    			<td>${id}</td>
		        <td>${username}</td>
		        <td>${date}</td>
		        <td>${time} </td>
		        <td>${status}</td>
		        <td>${total}</td>
    			
    			</tr>
    			
    						
	
	</table>
	</div>
	<BR>
	<BR>
	<H2><center>PRODUCTS</center></H2>
	<br>	
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
		</c:forEach>
	</table>
	</div>
	<br>
		
		<c:if test="${status == 'Pending Confirmation'}" >
			
			<c:if test="${check == 'check'}" >
				<center>
	       			<a href = "/dbms/admin/orders/${order_id}/cancel">
						<button class="button button1">CANCEL ORDER</button>
					</a>	
				
	       			<a href = "/dbms/admin/orders/${order_id}/confirm">
						<button class="button button1">CONFIRM ORDER</button>
					</a>	
				
       				<a href = "/dbms/admin/orders">
						<button class="button button1">ALL ORDERS</button>
					</a>	
				</center>
				
			</c:if>
			
			<c:if test="${check == 'cancel'}" >
				<CENTER><h2>Are you sure you want to cancel?</h2></CENTER><BR>
				<center>
       				<a href = "/dbms/admin/orders/${order_id}/cancelconfirm">
						<button class="button button1">YES</button>
					</a>	
				
       				<a href = "/dbms/admin/orders/${order_id}">
						<button class="button button1">GO BACK</button>
					</a>	
				</center>
				
			</c:if>
			
			<c:if test="${check == 'confirm'}" >
				<CENTER><h2>Are you sure you want to confirm?</h2></CENTER>
				<center>
       				<a href = "/dbms/admin/orders/${order_id}/confirmconfirm">
						<button class="button button1">YES</button>
					</a>	
				
       				<a href = "/dbms/admin/orders/${order_id}">
						<button class="button button1">GO BACK</button>
					</a>	
				</center>
				
			</c:if>
		</c:if>
		
		<c:if test="${status == 'Cancelled'}" >
		
			<center>
       		<a href = "/dbms/admin/orders">
				<button class="button button1">ALL ORDERS</button>
			</a>	
		</center>
			
			
		</c:if>
		
		<c:if test="${status == 'Confirmed'}" >
		
		<center>
       		<a href = "/dbms/admin/orders">
				<button class="button button1">ALL ORDERS</button>
			</a>	
		</center>
				
			
		</c:if>
		
		
	<br>
	
        
		
</body>
</html>