package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDataAccessObject;

@WebServlet("/Login")
//This uses the Login action from Login.jsp
public class Login extends HttpServlet {
	LoginDataAccessObject loginDAO = new LoginDataAccessObject();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		//Get the parameters from request
		
		//Check if the username and password match values
		if(loginDAO.check(uname, pass)) {
			//Log that a person got in 
			loginDAO.log(uname, pass, "y");
			//If they match create a session with the username and send them to the welcome page
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			if(uname.equals("Goutham")) {
				//If they're cool send them to see all the users
				response.sendRedirect("Users.jsp");
			}
			else {
				//If not they get the default welcome page
				response.sendRedirect("Welcome.jsp");
			}
		}
		//If they don't send the user back to the login page
		else {
			loginDAO.log(uname, pass, "n");
			response.sendRedirect("Login.jsp");
			//if the username and password don't match, send them back to the login screen
		}
	}

}
