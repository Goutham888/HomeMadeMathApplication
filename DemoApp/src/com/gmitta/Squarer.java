package com.gmitta;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;

//@WebServlet("/square")
//This is a servlet annotation. 
//It eliminates the need for a web.xml by having the URL contained in the servlet

public class Squarer extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		//1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
		//int k = (int)req.getAttribute("k");
		//This is used when requestDispatcher sends the req and res objects from adder to squarer
		//It gets the attribute attached to req from adder and uses it in the calcs
		//-------------------------------------------------------------------------------------------------------
		
		//22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
		//int k = Integer.parseInt(req.getParameter("k"));
		//The k paremeter comes from the rewritten url in the sendDirect method used in Adder
		//The req and res objects are different from the ones in Adder
		//-------------------------------------------------------------------------------------------------------
		
		//3333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333
		//HttpSession session = req.getSession();
		//int k = (int)session.getAttribute("k");
		//Session can call the attribute by the name you gave it
		//The data can be deleted with the session.removeAttribute("k"); method
		//--------------------------------------------------------------------------------------------------------
		
		//444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444
		int k=0;
		Cookie[] cookies = req.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals("k")) {
				k=Integer.parseInt(c.getValue());
			}
		}
		//the request object has the cookies because the browser sent a new request
		//The cookies are brought in as an array
		//You gotta loop through to find the right one
		//------------------------------------------------------------------------------------------------------------
		
		k*=k;
		
		PrintWriter out = res.getWriter();
		out.println("The square is "+k);
		System.out.println("Sauce is fired");
	}
}
