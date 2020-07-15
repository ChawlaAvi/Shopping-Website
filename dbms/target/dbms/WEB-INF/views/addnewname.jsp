<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


	<form:form method="post" modelAttribute="product" action="dbms/admin/addproduct/{product_id}">
		<table>
		
		
		<tr><td>
		Product Name</td><td>
		<form:input path="product_name" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="product_name" /></td></tr>
		
				<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>
	
	<a href="login">Login</a>