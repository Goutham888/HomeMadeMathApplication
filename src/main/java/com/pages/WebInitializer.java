package com.pages;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//needs to extend this abstract class for it to work

//completely replaces web.xml

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// idk how imp this is yet
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		//tells it to configure the servlet using the config class instead of the telusko-servlet.xml
		return new Class[] {ProjectConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// <url-pattern>/<url-pattern> (default landing) replacement
		return new String[] {"/"}; 
		//you can specify multiple types of patterns to be routed here b/c its an array of Strings
		// the / means all url patterns are routed to this 
	}
	

}
