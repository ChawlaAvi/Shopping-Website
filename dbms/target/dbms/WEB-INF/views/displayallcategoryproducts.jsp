
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>
</head>
<body>
	<h1> adding items for ${product.product_name}</h1>

	<h3>Select the category you want to add new items to</h3>
		<c:forEach items="${allcategories}" var="category">
		    <tr>      
		        
		        <td><a href="/dbms/admin/addproduct/${product.product_id}/${category.packet_size}">${category.packet_size} </a></td>
		    	<td>Price : ${category.price}</td>
		    	<td>Quantity: ${category.quantity}</td>
		    	<br><br>
		    </tr>
		    <br>
		</c:forEach>
	<br>
	<h3><a href = "/dbms/admin/addproduct/${product.product_id}/categoryadd">Add new category</a></h3>
	<a href="/dbms/admin/dashboard">Dashboard</a>
</body>
</html>