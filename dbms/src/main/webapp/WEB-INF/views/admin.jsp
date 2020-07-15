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
   <li class="active"><a href='/dbms/admin'>Dashboard</a></li>
   <li><a href='/dbms/admin/addproduct'>Add Products</a></li>
   <li>	<a href="/dbms/admin/allproducts">Manage Products</a></li>
   <li ><a href="/dbms/admin/allworkers">Workers</a></li>
    <li style="float:right"><a href="<c:url value="/j_spring_security_logout" />"> Logout</a></li>
  <li style="float:right"><a href="/dbms/admin/orders">Orders</a></li>
   <li style="float:right"><a href="/dbms/admin/customers">Customers</a></li>

</ul>
</div>

   <br><br><br><br><br><br><br><br>
 
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h1>
           <center> WELCOME </center>
        </h1>
	        <h2>
           <center> ${user} </center>
        </h2>
		        
    </c:if>
</body>
</html>
