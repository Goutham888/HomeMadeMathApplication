package com.dao;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.postgresql.util.ByteBufferByteStreamWriter;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {
	/* FOR ORACLE
	 * String url = "jdbc:oracle:thin:@:1521/orcl.fios-router.home";
	String username = "c##goutham";
	String password = "Oracle_2020";*/
	
	//This is the login information for the current DB don't steal it
	String userName = "postgres";
	String password = "PostgreSQL_2230?";
	String hostname = "localhost";
	String port = "5433";
	String dbName="postgres";
	String jdbcUrl = "jdbc:postgresql://"+hostname+":"+port+"/"+dbName;
	
	//Method for adding a user to the DB with the underlying datafields
	//Maybe a user object is warranted soon, if I want to do to a table to show who's using the website
	public void addUser(String uname, String pass, String firstName, String lastName, String email) {
		try {//Java forced me to do this to avoid Exceptions from the DB
			//Making the connection, soon this will be offloaded under the com.util package
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			
			//Just confirming the connection
			System.out.println("Got DB connection");
			
			//A statement accepting values for all the columns of a user
			PreparedStatement ps = con.prepareStatement("insert into users values(?, ?, ?, ?, ?)");
			//these just replace the ?'s with the actual datafields entered in the signup.jsp
			ps.setString(1, uname);
			//Passwords are SHA-256 encrypted before being put in the database
			ps.setString(2, getSHA(pass));
			ps.setString(3, firstName);			
			ps.setString(4, lastName);
			ps.setString(5, email);
			System.out.println(ps.executeUpdate());
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		
	}
	
	//This code is for checking if a user logging in has the right credentials
	public boolean check(String uname, String pass) {
		//default denial of entry
		boolean validID=false;
		try {//Java forced me to do this to avoid Exceptions from the DB
			//Making the connection, soon this will be offloaded under the com.util package
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			
			//Just confirming the connection
			System.out.println("Got DB connection");
			
			//Just selecting from the database if there is a username and password match
			PreparedStatement ps = con.prepareStatement("select * from users where username=? and password=?");
			
			//Replacing the ?'s with the actually input data
			ps.setString(1, uname);	
			//The password is SHA-256 protected so there's another method that encrypts the password given and compares 
			//it with the one in the DB
			ps.setString(2, getSHA(pass));
			
			//Query is executed
			ResultSet rs = ps.executeQuery();
			//If there is a record with matching credentials, access is allowed
			 if(rs.next()) {
				 validID=true;
			 }
			 //closing the statement
			 ps.close();
			 //return whether or not the person is allowed in
			 return validID;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//If there is a DB error, just return false
			return validID;
		} 
	}
	
	//An inside method that's used to encrypt the password given either in checking the login or inputting the given
	//password when signing up
	private String getSHA(String input) throws NoSuchAlgorithmException 
	 {  
	        // Static getInstance method is called with hashing SHA  
	        MessageDigest md = MessageDigest.getInstance("SHA-256");  
	  
	        // digest() method called  
	        // to calculate message digest of an input
	        return new String(md.digest(input.getBytes(StandardCharsets.UTF_8)));  
	 }
		
		
	}