<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	
	
	<!-- This is a directive, it is used for importing packages and mores stuff -->
	<%@
		page import="java.util.Scanner"
	 %>
	
	<!-- This is a declaration, the x is instantiated outside of the service method in the Welcome servlet
	If I wanted it inside the service method I would just put it inside the scriptlet -->
	<%!
		int x=5;
	%>
	<!-- Everything in the next tag goes into the service method of the Welcome servlet 
	This is known as a scriptlet-->
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		//Makes sure that the page can't be accessed from without logging in
		//If you try to get to the page by just typing in the URL, it will redirect you to login
		if(session.getAttribute("username")==null){
			response.sendRedirect("Login.jsp");
		}
		//If this works, then it displays welcome
	%>
	
	<!-- This tag is an expression, it is used to print out the values of numbers in the declaration
	It basically converts anything inside it into out.print(x) -->
	I really like <%= x%>
	<br>
	Welcome ${username}
	<!-- The ${username} is an example of JSTL
	You didn't do the tutorial for this so good luck -->
	<br>
	<!-- This is a link to the next webpage -->
	<a href="Videos.jsp">Click To Get The Special Sauce</a>
	
	<!-- This is a logout button that connects to Logout.java -->
	<form action="Logout">
		<input type="submit" value="Logout">
	</form>
</body>
</html>