<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<form:form method="post" modelAttribute="category" action="dbms/admin/addproduct/${category.product_id}/${category.packet_size}">
		<table>
		
		<form:hidden path="packet_size"></form:hidden>
		<form:hidden path="price"></form:hidden>
		<form:hidden path="product_id"></form:hidden>
		
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