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

import com.dao.QuestionsDAO;
import com.dao.WorksheetsDAO;
import com.dao.UserDAO;

@Controller
public class UserController {
	@Autowired
	QuestionsDAO qdao;
	
	@Autowired
	WorksheetsDAO wdao;
	
	@Autowired
	UserDAO udao;
	
	@RequestMapping("signup")
	public ModelAndView signup(@RequestParam("uname") String uname, @RequestParam("pass") String pass, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		udao.addUser(uname, pass, firstName, lastName, email);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping("login")
	public ModelAndView login(@RequestParam("uname") String uname, @RequestParam("pass") String pass) {
		String incorrectDisplay="";
		String nextPage="";
		if(udao.check(uname, pass)) {
			nextPage="index";
		}
		else {
			nextPage="login";
			incorrectDisplay="Incorrect credentials";
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName(nextPage);
		mv.addObject("incorrectDisplay", incorrectDisplay);
		return mv;
	}
	
}
