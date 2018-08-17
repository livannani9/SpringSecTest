<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function getAll() {
		document.forms[0].action = "getall";
		document.forms[0].method = "get";
		document.forms[0].submit();
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
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

<body>
	<h2 align="center">Register</h2>
	<center>
		<form action="reg" method="post">
			<table align="center" style="margin: 0px auto;">
				<tr>
					<td>Name</td>
					<td><input type="text" placeholder="Enter Name" name="user_name" style="height: 30px;width: 200px;padding-left: 10px;"/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" placeholder="Enter Email" name="user_email" style="height: 30px;width: 200px;padding-left: 10px;"/></td>
				</tr>
				<tr>
					<td>Mobile No</td>
					<td><input type="text" placeholder="Enter Mobile" name="user_mobile" style="height: 30px;width: 200px;padding-left: 10px;"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" placeholder="Enter Password" name="user_password" style="height: 30px;width: 200px;padding-left: 10px;"/></td>
				</tr>
				<tr>
					<td colspan="1"><input type="submit" value="Register" style="height: 30px;" /></td>
					<td><input type="button" value="getall" onclick="getAll()" style="height: 30px;">
					<a href="login.jsp">login</a></td>
				</tr>
			</table>
		</form>
		<form action="sTone" method="post">
			<table>
				<tr>
					<td><input type="submit" value="singleTone"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</div>
</html>