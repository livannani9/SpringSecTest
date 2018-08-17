<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<center>
	<h3>Profile Page</h3>
</center>
<script type="text/javascript">
	function openInEditMode(user_email) {
		alert("Open in Edit Mode triggerd for :" + user_email);
		document.forms[0].action = "editMode?mail=" + user_email;
		document.forms[0].method = "post";
		document.forms[0].submit();
	}
	function deleteUser(user_email) {
		alert("Open in Delete triggerd for :" + user_email);
		document.forms[0].action = "deleteuser?mail=" + user_email;
		document.forms[0].method = "post";
		document.forms[0].submit();

	}
</script>
<center>
	<body>
		Hello Welcome To Home Page ${username.user_name}
		<form action="">
			<table border="3" bordercolor="Black">
				<tr style="color: black">
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Mobile</th>
					<th>Password</th>
				</tr>
				<core:forEach var="user" items="${usersList}">
					<tr>
						<td><core:out value="${user.user_id}"></core:out></td>
						<td><core:out value="${user.user_name}"></core:out></td>
						<td><core:out value="${user.user_email}"></core:out></td>
						<td><core:out value="${user.user_mobile}"></core:out></td>
						<td><core:out value="${user.user_password}"></core:out></td>
						<td><input type="button" value="Edit"
							onclick="openInEditMode('${user.user_email}')" /></td>
						<td><input type="button" value="Delete"
							onclick="deleteUser('${user.user_email}')" /></td>
					</tr>
				</core:forEach>
			</table>
		</form> 
		<a href='<core:url value="j_spring_security_logout"/>'>Logout</a>
		</body>
</center>
</html>