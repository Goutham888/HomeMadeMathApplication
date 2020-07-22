package com.util;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.security.MessageDigest;


public class UtilMethods {
	String url = "jdbc:oracle:thin:@:1521/orcl.fios-router.home";
	String username = "c##goutham";
	String password = "Oracle_2020";

	public Connection establishConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public Timestamp getCurrentTime(){
		// 1) create a java calendar instance
		Calendar calendar = Calendar.getInstance();
		// 2) get a java.util.Date from the calendar instance.
		//this date will represent the current instant, or "now".
		java.util.Date now = calendar.getTime();
		// 3) a java current time (now) instance
		Timestamp currentTimestamp = new Timestamp(now.getTime());
		return currentTimestamp;
	}

	 public String getSHA(String input) throws NoSuchAlgorithmException 
	 {  
	        // Static getInstance method is called with hashing SHA  
	        MessageDigest md = MessageDigest.getInstance("SHA-256");  
	  
	        // digest() method called  
	        // to calculate message digest of an input
	        return new String(md.digest(input.getBytes(StandardCharsets.UTF_8)));  
	 } 
}
