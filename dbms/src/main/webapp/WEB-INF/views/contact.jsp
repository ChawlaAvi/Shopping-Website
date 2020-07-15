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
<title>Remove Item</title>
</head>
<body onload='document.loginForm.j_username.focus();'>


<div id='cssmenu'>
<ul>
   <li><a href='/dbms'>Home</a></li>
   <li style="float:right"><a href='login'>Login</a></li>
   <li style="float:right"><a href='register'>Register</a></li>
   <li class="active "><a href='/dbms/contact'>Contact</a></li>
</ul>
</div>
<center>
	<h1>CONTACT US</h1>
	<br><br>
	
	<div class="w3-container">
	
			<table class="w3-table-all w3-card-4" align="center" >
				<tr>
      				<td>Name:</td><td>Ankit Chhabra</td>
      				</tr>
      			<tr>	<td>Address:</td><td>Layalpur Traders, Mandi Road, Rudrapur, Uttrakhand, Pin-263153		</td> </tr>
      			<tr>	<td>Loaction</td><td><a href="https://wego.here.com/india/rudrapur/business-services/layalpur-traders--356jx7ps-ebe155084c5e0b11e8365ba7eeac6d65?x=ep&map=28.97502,79.39452,15,normal">Here</a></td>
      				
      				
    			</tr>
    			<td>Contact Number</td><td>+91-9927041023</td>
    			</tr>
    			<td>Email Id</td><td>......</td>
 
    			
	</table>
</div>
	
	
	

</body>
</html>