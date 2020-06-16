package com.javahonk;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class PaginationServlet
 */
@WebServlet("/PaginationServlet")
public class PaginationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaginationServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, 
     * HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, 
	    HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("application/json");

	response.setContentType("application/json");
	PrintWriter out = response.getWriter();
	List<Person> personsList = new ArrayList<Person>();
	for (int i = 0; i < 1; i++) {
	    Person person2 = new Person();
	    person2.setName("John Landy");
	    person2.setPosition("System Architect");
	    person2.setSalary("$320,800");
	    person2.setOffice("NY");
	    person2.setPhone("999999999");
	    person2.setStart_date("05/05/2010");
	    personsList.add(person2);

	    person2 = new Person();
	    person2.setName("Igor Vornovitsky");
	    person2.setPosition("Solution Architect");
	    person2.setSalary("$340,800");
	    person2.setOffice("NY");
	    person2.setPhone("987897899");
	    person2.setStart_date("05/05/2010");
	    personsList.add(person2);

	    person2 = new Person();
	    person2.setName("Java Honk");
	    person2.setPosition("Architect");
	    person2.setSalary("$380,800");
	    person2.setOffice("NY");
	    person2.setPhone("1234567890");
	    person2.setStart_date("05/05/2010");
	    personsList.add(person2);

	    person2 = new Person();
	    person2.setName("Ramesh Arrepu");
	    person2.setPosition("Sr. Architect");
	    person2.setSalary("$310,800");
	    person2.setOffice("NY");
	    person2.setPhone("4654321234");
	    person2.setStart_date("05/05/2010");
	    personsList.add(person2);

	    person2 = new Person();
	    person2.setName("Bob Sidebottom");
	    person2.setPosition("Architect");
	    person2.setSalary("$300,800");
	    person2.setOffice("NJ");
	    person2.setPhone("9876543212");
	    person2.setStart_date("05/05/2010");
	    personsList.add(person2);

	    person2 = new Person();
	    person2.setName("Kirti Khanna");
	    person2.setPosition("System Architect");
	    person2.setSalary("$320,800");
	    person2.setOffice("NY");
	    person2.setPhone("999999999");
	    person2.setStart_date("05/05/2010");
	    personsList.add(person2);

	}

	for (int i = 0; i < 15; i++) {
	    Person person2 = new Person();
	    person2.setName("Zuke Torres");
	    person2.setPosition("System Architect");
	    person2.setSalary("$320,800");
	    person2.setOffice("NY");
	    person2.setPhone("999999999");
	    person2.setStart_date("05/05/2010");
	    personsList.add(person2);

	}

	PersonJsonObject personJsonObject = new PersonJsonObject();
	personJsonObject.setiTotalDisplayRecords(personsList.size());
	personJsonObject.setiTotalRecords(personsList.size());
	personJsonObject.setAaData(personsList);

	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String json2 = gson.toJson(personJsonObject);
	out.print(json2);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, 
     * HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, 
	    HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
    }

}
