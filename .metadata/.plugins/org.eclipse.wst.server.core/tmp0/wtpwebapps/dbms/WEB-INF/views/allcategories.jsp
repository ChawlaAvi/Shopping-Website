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
	<h3>Categories</h3>
		<c:forEach items="${allcategories}" var="category">
		    <tr>      
		    	<td>${category.categoryid}</td>
		        <td><a href="/dbms/categories/${category.categoryid}">${category.categoryname}</a></td>
		    </tr>
		    <br>
		</c:forEach>
	<br>
	<h3>${message}</h3>
	<a href="/dbms/admin">Dashboard</a>
</body>
</html>