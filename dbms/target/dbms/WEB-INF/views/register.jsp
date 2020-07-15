<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<form:form method="post" modelAttribute="user" action="register">
		<table><tr><td>
		Username</td><td>
		<form:input path="username" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="username" /></td></tr>
		
		<tr><td>
		Password</td><td>
		<form:input path="password" type="password" /> </td><!-- bind to user.name-->
		<td><form:errors path="password" /></td></tr>
		
		<tr><td>Confirm Password</td>
		<td>
		<form:input path="mpassword" type="password" /> </td><!-- bind to user.name-->
		<td><form:errors path="mpassword" /></td></tr>
		
		<tr><td>Name</td>
		<td>
		<form:input path="name" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="name" /></td></tr>
		
		<tr><td>Address</td>
		<td>
		<form:input path="address" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="address" /></td></tr>
		
		
		<tr><td>Aadhar Number</td>
		<td>
		<form:input path="aadharnumber" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="aadharnumber" /></td></tr>
		<tr>
		
		<tr><td>Phone</td>
		<td>
		<form:input path="phone_number" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="phone_number" /></td></tr>
		<tr>
		<tr><td>Mail</td>
		<td>
		<form:input path="email" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="email" /></td></tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>
	
	<a href="login">Login</a>