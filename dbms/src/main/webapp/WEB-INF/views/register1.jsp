<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url var="css" value="/css" />


<html>

<head>
<title>Register</title>
<link rel="stylesheet" type="text/css" href="${css}/styles.css" />
<link rel="stylesheet" type="text/css" href="${css}/main.css" />

</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<jsp:include page='navbar.jsp'/>

<br>
	<h3>Register</h3>
<div class="container">
  <div class="row">
    <div class="Absolute-Center is-Responsive">
      <div id="logo-container"></div>
      <div class="col-sm-12 col-md-10 col-md-offset-1">

	<form:form method="post" modelAttribute="user" action="register">
		<div class="form-group input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	
				<form:input path="username"  class="form-control" type="text" name='username' placeholder="username"/>          
         		<form:errors path="username" />
         </div>
		
		<div class="form-group">
            <button type="button" class="btn btn-def btn-block" value="Submit" >Login</button>
        </div>
		
		<tr><td>${error}</td></tr>
		</form:form>        
      </div>  
    </div>    
  </div>
</div>

	</body>
	</html>
