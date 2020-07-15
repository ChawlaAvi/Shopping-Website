<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url var="css" value="/css" />


<html>

<head>
<title>Register</title>
<link rel="stylesheet" type="text/css" href="${css}/styles.css" />

</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<div id='cssmenu'>
<ul>
   <li><a href='/dbms'>Home</a></li>
   <li style="float:right"><a href='login'>Login</a></li>
   <li class="active" style="float:right"><a href='register'>Register</a></li>
   <li><a href='/dbms/contact'>Contact</a></li>
</ul>
</div>
<br>

<center>
	<h2>REGISTER</h2>


	<form:form method="post" modelAttribute="user" action="register">
	
	
		
		
		
		<table>
		<tr>
			<td>Username</td>
			<td><form:input path="username" type="text" placeholder="username" required="true"/> </td>
			<td><form:errors path="username" /></td>
		</tr>
		
		<tr><td>
		Password</td><td>
		<form:input path="password" type="password" placeholder="password" required="true"/> </td>
		<td><form:errors path="password" /></td></tr>
		
		<tr><td>Confirm Password</td>
		<td>
		<form:input path="mpassword" type="password" placeholder="password" required="true"/> </td>
		<td><form:errors path="mpassword" /></td></tr>
		
		<tr><td>Name</td>
		<td>
		<form:input path="name" type="text" placeholder="name" required="true"/> </td>
		<td><form:errors path="name" /></td></tr>
		
		<tr><td>Address</td>
		<td>
		<form:input path="address" type="text" placeholder="address" required="true"/> </td>
		<td><form:errors path="address" /></td></tr>
		
		
		<tr><td>Aadhar Number</td>
		<td>
		<form:input path="aadharnumber" type="text" placeholder="aadhar no" required="true"/> </td>
		<td><form:errors path="aadharnumber" /></td></tr>
		<tr>
		<td>Sex</td>
		<td>
		<form:input path="sex" type="text" required="true" placeholder="M/F" pattern="[M,F]{1}"/> </td>
		<td><form:errors path="sex" /></td></tr>
		
		<tr><td>Phone</td>
		<td>
		<form:input path="phone_number" type="tel" placeholder="1234567890" pattern="[0-9]{10}" required="true"/> </td><!-- bind to user.name-->
		<td><form:errors path="phone_number" /></td></tr>

		<tr><td>Mail</td>
		<td>
		<form:input path="email" type="text" placeholder="email" required="true"/> </td>
		<td><form:errors path="email" /></td></tr>
		<tr>
		
		
			<td><input type="submit" value="Submit" /></td>
			</tr>
    
			
		
		</table>
		
	</form:form>
	<p>${error}</p>
	</center>
	
	</body>
	</html>
