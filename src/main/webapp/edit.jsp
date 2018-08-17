<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body>	<h2 align="center">Edit</h2>
	Hello Welcome To Home Page....${username.user_name}
	<center>
		<form action="updateUser"  method="post">
			<table align="center" style="margin: 0px auto;">
				<tr>
					<td>Name</td>
					<td><input type="text" name="user_name"  value="${user.user_name}"/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="user_email"  value="${user.user_email}"/></td>
				</tr>
				<tr>
					<td>Mobile No</td>
					<td><input type="text" name="user_mobile" value="${user.user_mobile}"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="user_password" value="${user.user_password}"/></td>
				</tr>
				<tr>
					<td colspan="1"><input type="submit" value="Update" /></td>
				</tr>

			</table>
		</form>
	</center>

</body>
</html>