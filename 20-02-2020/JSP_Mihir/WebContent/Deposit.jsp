<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit</title>
</head>
<body>
	<%
		if (session.getAttribute("ID") == null) {
			response.sendRedirect("index.jsp");
			//System.out.println("AA");
		} else {
	%>
	<form action="Deposit">
		Enter Amount:<input type="text" name="amount"><br>
		<input type="submit" name="submit" value="submit">
	</form>
	<%
		}
	%>
</body>
</html>