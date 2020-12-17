package com.pages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.WorksheetsDAO;
import com.dao.UserDAO;

@Controller
public class UserController {
	
	
	@Autowired
	WorksheetsDAO wdao;
	
	@Autowired
	UserDAO udao;
	
	@RequestMapping("/signup")
	public ModelAndView signup(@RequestParam("uname") String uname, @RequestParam("pass") String pass, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		udao.addUser(uname, pass, firstName, lastName, email);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	//Mapping it to the login command in login.jsp
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("uname") String uname, @RequestParam("pass") String pass) {
		//incorrectDisplay and nextPage are given values depending on if the login credentials were correct or wrong
		String incorrectDisplay="";
		String nextPage="";
		//If the uname and password check out, then the user is directed to the homescreen
		//Eventually they should be directed to a secure page with http sessions where they can submit worksheets
		//for review
		if(udao.check(uname, pass)) {
			//the nextPage value has redirect:/ in front of it so it redirects the actual URL to index.jsp
			//therefore activating the /index request mapping in IndexController.java to show the worksheet
			//statistics.
			nextPage="redirect:/index";
		}
		//Else the page is just reloaded and incorrectDisplay is given a value so it shows up on the screen. 
		else {
			nextPage="login";
			incorrectDisplay="Incorrect credentials";
		}
		//Creating model and view object
		ModelAndView mv = new ModelAndView();
		//Setting the next page
		mv.setViewName(nextPage);
		//Adding the incorrectDisplay datafield
		mv.addObject("incorrectDisplay", incorrectDisplay);
		//returning the object
		return mv;
	}
	
}
