package com.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.*;
import com.login.dao.LoginDataAccessObject;

/**
 * Servlet implementation class PaginationServlet
 */
@WebServlet("/UserDataTableServlet")
public class UserDataTableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDataTableServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, 
     * HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	
		PrintWriter out = response.getWriter();
		
		LoginDataAccessObject ldao = new LoginDataAccessObject();
		
		List<User> userList = ldao.getAllUsers();
		
		UserJsonObject userJsonObject = new UserJsonObject();
		userJsonObject.setiTotalDisplayRecords(userList.size());
		userJsonObject.setiTotalRecords(userList.size());
		userJsonObject.setAaData(userList); 
	
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json2 = gson.toJson(userJsonObject);
		out.print(json2);
    }

  }
