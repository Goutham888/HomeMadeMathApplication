package com.pages;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/*
 	This completely replaces the servlet.xml file
 	The @Configuration makes this a config file
 	The @ComponentScan searches for controllers in the specified package
 	More packages can be added  just as  a list.
	IE @ComponentScan({"com.telusko", "com.telusko.service"})
 */
@Configuration
@ComponentScan({"com.pages", "com.dao"})
@EnableWebMvc
public class ProjectConfig implements WebMvcConfigurer{
	//not entirely sure what a bean is
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("");//Tells the classpath of the .jsp files
		//The index.jsp has to be in the webapp folder, not in WEB-INF
		vr.setSuffix(".jsp");//says that the type of file that is being send to is .jsp
		
		return vr;
	}
	
	
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	//Telling it that this path is a valid place to find resources
    	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    

}
