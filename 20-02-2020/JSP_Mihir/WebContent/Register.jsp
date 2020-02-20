<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
</head>
<body>
<form action="RegisterUserSuccess" method="post">
	User ID (Less than 30 characters):<input type="text" name="userID"><br>
	Password (Less than 30 characters):<input type="password" name="password"><br>
	User Name (Less than 30 characters):<input type="text" name="userName"><br>
	Phone Number (10 characters): <input type="text" name="phoneNumber"><br>
	<input type="submit" name="Register"><br>
</form>
</body>
</html>