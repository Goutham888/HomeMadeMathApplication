<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	
	<!-- This is a form that accepts username and password
	The action is login, it is used by a Login.java through annotation -->
	<form action="Login" method="post">
		Enter username: <input type="text" name="uname"><br>
		Enter password: <input type="password" name="pass"><br>
		<input type="submit" value="login"><br><br>
		Don't have an account? <a href="Signup.jsp">Sign up!</a>
	</form>
	
	<br><br>
	

	
</body>
</html>