package com.login.SignUp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.SignUpDAO;


@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	
	SignUpDAO sgdao = new SignUpDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		//Get the parameters from request
		
		sgdao.updateRecords(uname, pass, firstName, lastName);
		response.sendRedirect("Login.jsp");
	}

}
