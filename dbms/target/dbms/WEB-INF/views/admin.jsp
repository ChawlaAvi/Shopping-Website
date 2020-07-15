<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
    <h1>Name : ${name}</h1>
    <h1>Description : ${description}</h1>
 
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome : ${user} | 
        </h2>
        <a href="/dbms/admin/addproduct">Add a new Product</a><br>
        <a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
    </c:if>
</body>
</html>
