<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	
	<h1>Adding new category for ${product.product_name}</h1>
	<form:form method="post" modelAttribute="category" action="dbms/admin/addproduct/${product.product_id}/categoryadd">
		<table>
		<form:hidden path="product_id"></form:hidden>
		
		<tr><td>
		Product Size</td><td>
		<form:input path="packet_size" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="packet_size" /></td></tr>
		<tr><td>
		Product Price</td><td>
		<form:input path="price" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="price" /></td></tr>
		<tr><td>
		Quantity</td><td>
		<form:input path="quantity" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="quantity" /></td></tr>
		
				<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>
	
	<a href="login">Login</a>