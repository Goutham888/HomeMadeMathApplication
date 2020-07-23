package com.telusko;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.service.AddService;

@Controller//this means that it is a controller and is considered when dispatcher servlet is looking for controllers to pass info too
public class AddController {
	
	@RequestMapping("/add")//When this controller is checked, the request mapping matches the add action in the jsp
	public ModelAndView add(@RequestParam("t1") int i, @RequestParam("t2") int j/* HttpServletRequest req, HttpServletResponse res */) {//This means that this method is run
		/*
		 * int i = Integer.parseInt(req.getParameter("t1"));//Gets the values just like
		 * in normal servlets int j = Integer.parseInt(req.getParameter("t2"));
		 */
		 //The @RequestParam annotations above take care of getting variables so you don't have to do req.getParameter
		 AddService as = new AddService();//this is a service object, you don't do calculations in the controller
		 //all that needs to happen in a separate service class
		 int sum = as.add(i, j);
		 
		 ModelAndView mv = new ModelAndView();//spring mvc object that does special things
		 mv.setViewName("display");//sends us to display.jsp
		 //you are not supposed to add extensions in this statement bc it would be difficult to change if you have a lot of 
		 //pages and you suddenly switch to .html from .jsp, 
		 //the extension and location of the files are held in the servlet config under the viewresolver method
		 mv.addObject("result",sum);//attaches the sum as a result attached to the request object
		 
		 return mv;
	}
}
