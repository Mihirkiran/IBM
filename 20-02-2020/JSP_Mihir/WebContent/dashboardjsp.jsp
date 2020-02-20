<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<%
		if (session.getAttribute("ID") == null) {
			response.sendRedirect("index.jsp");
			//System.out.println("AA");
		} else {
	%>
	<a href="CheckBalance">Check Balance</a>|
	<a href="Deposit.jsp">Deposit</a>|
	<a href="Withdraw.jsp">Withdraw</a>|
	<a href="FundTransfer.jsp">Transfer Funds</a>|
	<a href="PrintTransactions">Transaction History</a>|
	<a href="Logout">Logout</a>
	<%
		}
	%>
</body>
</html>