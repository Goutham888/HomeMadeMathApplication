package com.learnfromexamples.jquerydatatable;

import java.io.IOException;
import java.util.Locale;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learnfromexamples.jquerydatatable.service.LoadDataService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class JQueryDatatableController {
	
	private static final Logger logger = LoggerFactory.getLogger(JQueryDatatableController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws JsonGenerationException, JsonMappingException, IOException {
		logger.info("Welcome home! The client locale is {}.", locale);
		LoadDataService dataService = new LoadDataService();
		ObjectMapper mapper = new ObjectMapper();
		model.addAttribute("employeeList", mapper.writeValueAsString(dataService.getEmployeeList()));
		return "home";
	}
	
}
