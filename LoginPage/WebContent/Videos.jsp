<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Videos</title>
</head>
<body>
		<!-- Everything in the next tag goes into the service method of the Welcome servlet 
		This is known as a scriptlet-->
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			//Makes sure that the page can't be accessed from without logging in
			//If you try to get to the page by just typing in the URL, it will redirect you to login
			if(session.getAttribute("username")==null){
				response.sendRedirect("Login.jsp");
			}
			//If this works, then it displays Videos
		%>
	Eyy you got the Sauce	
	<form action="Logout">
		<input type="submit" value="Logout">
	</form>
</body>
</html>