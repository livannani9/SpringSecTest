<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn</title>
</head>
<body>
<style>
.container {
  position: relative;
  border-radius: 5px;
  background-color: #bdac52;
  padding: 20px;
  width: 300px;
  align-content: center;
  margin-left: auto;
  margin-right: auto;
  
} 
</style>

<div class="container" >
<font style="color: red">
<h2 align="center" style="color:green;">Login</h2>
<h3 align="center">${msg}</h3>
</font>

<form action="${pageContext.request.contextPath}/<core:url value='j_spring_security_check'/>" method="post">
	<table align="center">
		<tr>
			<td>Email :</td>
			<td><input type="text" name="user_email" style="height: 30px;width: 200px;padding-left: 10px;"></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><input type="password" name="user_password" style="height: 30px;width: 200px;padding-left: 10px;"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Login" style="height: 30px;"></td>
			<td><a href="index.jsp">Register</a>
		</tr>


	</table>
</form>
</div>
</body>
</html>