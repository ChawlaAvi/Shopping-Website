<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url var="css" value="/css" />
<%@page session="true"%>
<html>
<head>
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="${css}/styles.css" />

</head>
<body>


    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div id='cssmenu'>
<ul>
   <li class="active"><a href='dashboard'>Dashboard</a></li>
   <li ><a href='/dbms/allproducts'>Store</a></li>
   <li style="float:right"><a href="<c:url value="/j_spring_security_logout" />"> Logout</a></li>
   <li style="float:right"><a href='/dbms/profile'>User Profile </a></li>
   <li style="float:right"><a href='/dbms/myorders'>My Orders</a></li>
   <li style="float:right"><a href='/dbms/myproducts'>My Cart</a></li>
  
   
   
</ul>
</div>
<BR>
<BR>
        <center>
        <h1>
            ${user} Logged In!!
        </h1>
		</center>
    </c:if>
</body>
</html>
