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

@Controller
public class IndexController {

	@Autowired
	WorksheetsDAO wdao;
	
	//the "/" request mapping means that this method is called as soon as the application is run
	//the "index" request mapping means that this method is called whenever index.jsp is linked to
	@RequestMapping({"/","index"})
	public ModelAndView indexPage() {
		//stats is filled with statistics from the database calculated by getStats();
		int[] stats = wdao.getStats();
		//Changes the view to index.jsp
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("stats",stats);
		return mv;
	}

	
	//Works with Testing.jsp to test worksheet uploads 
	//Needs to be moved to a better spot
	@RequestMapping("update")
	public void addWksht() {
		//The DB is accessed to upload a worksheet from a file location specified in the code
		wdao.addWorksheet();
	}
	

	
}
