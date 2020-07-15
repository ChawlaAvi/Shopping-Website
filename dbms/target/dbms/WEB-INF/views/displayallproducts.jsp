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
	<h3>Select the product you want to add new items to</h3>
		<c:forEach items="${allproducts}" var="product">
		    <tr>      
		    	
		        <td><a href="/dbms/admin/addproduct/${product.product_id}">${product.product_name}</a></td>
		    </tr>
		    <br>
		</c:forEach>
	<br>
	<h3> 
		<a href="/dbms/admin/addnewproductname">ADD NEW PRODUCT</a>
	</h3>
	<a href="/dbms/admin/dashboard">Dashboard</a>
</body>
</html>