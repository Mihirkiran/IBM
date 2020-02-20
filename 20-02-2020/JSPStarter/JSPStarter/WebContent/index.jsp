<%@ page import="java.util.Date, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Using JSP Declarations -->
<%!
int var;

int add(int a, int b){
	return a + b;
}
%>


<!-- Using JSP Scriplets -->
	<b> 
	<%
	
	 /*  response : HttpServletResponse*/
	 /* session.setAttribute(arg0, arg1); */ /* HttpSession */
	 application.setAttribute("", "");/* ServletContext */
	
		out.println("Welcome " + request.getParameter("userName") + "<br>");
	
	out.println("Addition is : " + this.add(78, 88));
	out.println("System current Time is : " + new Date());
	ArrayList<String> list = new ArrayList<>();
	
 	/* int a, b;
 	
 	a = 9877;
 	
 	out.println("Running Java in HTML!!!" + a);  */
 %> <select>
			<option>Please select your ID</option>
			<%
				for (int var = 345; var < 3000; var++) {
			%>
			<option>
			<!-- Using JSP expressions -->
				<%= "var" %>
			</option>
			<%
				}
			%>
	</select>

	</b>
</body>
</html>