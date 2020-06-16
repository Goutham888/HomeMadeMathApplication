package com.gmitta;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/add")
//This is a servlet annotation. 
//It eliminates the need for a web.xml by having the URL contained in the servlet

public class Adder extends HttpServlet{
	
	
	//The doPost method only accepts post actions, while service takes in all of them
	//The doGet method only accepts get actions
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		//req.getParameter() takes in the parameters from index.html using the request object
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i+j;
		
		/*it uses the response to push out the answer
		PrintWriter out = res.getWriter();
		out.println("The sum is "+ k);*/
		
		
		//1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
		/*req.setAttribute("k", k);
		RequestDispatcher rd = req.getRequestDispatcher("square");
		rd.forward(req, res);*/
		
		//request dispatcher sends the request and response object to the next servlet without the browser knowing
		//It also attaches the attribute of k to request so the data can be transferred to squarer as well
		//this is ok as long as its within the same website
		//If the sending is happening out a servlet that's not within the same website, you have to use sendRedirect
		//It tells the browser that it is being redirected to a new servlet and creates new request and response objects to handle that exchange	
		//------------------------------------------------------------------------------------------------------------------------------------------------
		
		//22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
		//res.sendRedirect("square?k="+k);
		
		//The response object does this because it it needs to respond to the browser that it is being redirected
		//sendRedirect sends the browser to a new servlet by giving it a URL
		//There is a new request object that looks through the URL to find its parameter
		//This is different from request dispatcher because the data is not attached to an object
		//We changed the URL so it doesn't just go to the square servlet
		//It also adds a parameter k that will be used in the servlet
		//-------------------------------------------------------------------------------------------------------------------------------------------------
	
		//3333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333
		//HttpSession session = req.getSession();
		//session.setAttribute("k", k);
		//res.sendRedirect("square");
		
		//YOU NEED THE SEND DIRECT HERE
		//HttpSession is an interface, TomCat provides an object with the getSession method
		//The attribute is set to k and redirected to Squarer,
		//The URL does not need to be rewritten like example 2
		//Very useful for login id and password checks b/c you need to check if they're logged in at every page they visit after the login screen
		//The attribute will stay as long as you don't delete it
		//-----------------------------------------------------------------------------------------------------------------------------------------------------
		
		//444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444
		Cookie cookie = new Cookie("k", k+"");
		res.addCookie(cookie);
		res.sendRedirect("square");
		
		//YOU NEED THE SEND DIRECT HERE
		//Cookies allow you to hold data about a user, kinda like a session but longer term?
		//I didn't really understand the explanation
		//Cookies are an object, they take in a key and a String value
		//If you just append "" to an integer it becomes a String and therefore valid for a cookie value
		//Response adds a cookie and kicks everything back to the browser. 
		//The browser sends a request to the Squarer servlet
		//The request object in the Squarer servlet will have access to the cookie after this.
		
	}
}
