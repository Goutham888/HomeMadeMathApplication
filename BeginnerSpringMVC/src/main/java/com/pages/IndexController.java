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

@Controller
public class IndexController {
	@Autowired
	QuestionsDAO qdao;
	
	@Autowired
	WorksheetsDAO wdao;
	
	List<String> questionList = new ArrayList<String>();
	@RequestMapping("/")
	public ModelAndView indexPage() {
		int[] stats = wdao.getStats();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("stats",stats);
		return mv;
	}
	
	@RequestMapping("update")
	public void addWksht() {
		wdao.addWorksheet();
	}
	
	@RequestMapping("upload")
    public String upload(/*@RequestParam("file") MultipartFile file*/) throws IOException {
    	System.out.println("Hey I got a file");
    	return "index.jsp";
    }
	/*I just wanna keep it for code parts
	@RequestMapping("questions")
	public ModelAndView loginPage() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("questions");
		
		System.out.println("about to loop");
		for(int i=1; i<=5; i++) {
			System.out.println("Question: "+ qdao.getQuestion(i));
			questionList.add(qdao.getQuestion(i));
			//mv.addObject("Question"+i, qdao.getQuestion(i));
		}
		System.out.println(questionList.toString());
		mv.addObject("questionList",questionList);
		return mv;
	}
	*/
	
	@RequestMapping("checkAnswers")
	public ModelAndView checkAnswers(@RequestParam("Q1") String q1, @RequestParam("Q2") String q2, @RequestParam("Q3") String q3, @RequestParam("Q4") String q4, @RequestParam("Q5") String q5) {
		int result=0;
		System.out.println(questionList.toString());
		result+=qdao.checkQA(q1, questionList.get(0));
		result+=qdao.checkQA(q2, questionList.get(1));
		result+=qdao.checkQA(q3, questionList.get(2));
		result+=qdao.checkQA(q4, questionList.get(3));
		result+=qdao.checkQA(q5, questionList.get(4));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("results");
		mv.addObject("result", result);
		return mv;
		
	}
	 
	
}
