<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url var="css" value="/css" />

<html>

<head>
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${css}/styles.css" />

</head>
<body onload='document.loginForm.j_username.focus();'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<div id='cssmenu'>
<ul>
   <li><a href='/dbms'>Home</a></li>
   <li class="active "style="float:right"><a href='login'>Login</a></li>
   <li style="float:right"><a href='register'>Register</a></li>
   <li><a href='/dbms/contact'>Contact</a></li>
</ul>
</div>
<center>
	<h2>LOGIN</h2>

	<%
		String errorString = (String) request.getAttribute("error");
		if (errorString != null && errorString.trim().equals("true")) {
			out.println("<span class=\"errorblock\">Incorrect login name or password. Please try again");
		}
	%>

	<form name='loginForm' action="<c:url value='login' />" method='POST'>

		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' placeholder="username" value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' placeholder="password"/></td>
			</tr>
			
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
				<td><input name="reset" type="reset" /></td>
			</tr>
		</table>

	</form>
</center>	
</body>
</html>