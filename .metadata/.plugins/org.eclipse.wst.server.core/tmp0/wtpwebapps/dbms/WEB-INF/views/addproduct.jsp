<h1>Adding items for ${product.product_name}</h1>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


	<form:form method="post" modelAttribute="product" action="/dbms/admin/addproduct/${product.product_id}">
		<table>

		
		<tr><td>
		Product Price</td><td>
		<form:input path="productprice" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="productprice" /></td></tr>
		
		<tr><td>
		Product Price</td><td>
		<form:input path="productprice" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="productprice" /></td></tr>

			<tr>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>