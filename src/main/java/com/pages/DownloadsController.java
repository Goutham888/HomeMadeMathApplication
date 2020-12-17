package com.pages;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
 
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.WorksheetsDAO;
 
@Controller
public class DownloadsController {
     
    /**
     * Size of a byte buffer to read/write file
     */
    private static final int BUFFER_SIZE = 4096;
             
    /**
     * Path of the file to be downloaded, relative to application's directory
     */
    private String filePath = "/resources/downloads/";
   
    @Autowired
    private WorksheetsDAO wdao;
     
    /**
     * Method for handling file download request from client
     */
    
    //Method for opening up download screen for PDF
    //Needs more research to understand the nuances of what's going on
    @RequestMapping("download")
    public @ResponseBody HttpEntity<byte[]> downloadB(@RequestParam String filename) throws IOException {
        //The document is returned as a byte array from the DB
    	byte[] document = wdao.getWorksheet(filename);
    	//The HttpHeader is set to the file's content and returned
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "pdf"));
        header.set("Content-Disposition", "inline; filename="+filename);
        header.setContentLength(document.length);
        return new HttpEntity<byte[]>(document, header);
    }
}