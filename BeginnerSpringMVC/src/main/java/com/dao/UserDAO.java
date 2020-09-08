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
	

	String userName = "Goutham_Mitta";
	String password = "PostgreSQL_2230";
	String hostname = "quizdb.cm6lyukuizi2.us-east-1.rds.amazonaws.com";
	String port = "5432";
	String dbName="quizdb";
	String jdbcUrl = "jdbc:postgresql://"+hostname+":5432/quizdb";
	
	public void addUser(String uname, String pass, String firstName, String lastName, String email) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			
			System.out.println("Got DB connection");
			
			PreparedStatement ps = con.prepareStatement("insert into users values(?, ?, ?, ?, ?)");
			ps.setString(1, uname);
			
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
	public boolean check(String uname, String pass) {
		boolean good=false;
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			
			System.out.println("Got DB connection");
			
			PreparedStatement ps = con.prepareStatement("select * from users where uname=? and pass=?");
			ps.setString(1, uname);
			
			ps.setString(2, getSHA(pass));
			
			ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
				 good=true;
			 }
			 System.out.println(good);
			 ps.close();
			 return good;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return good;
		} 
	}
	private String getSHA(String input) throws NoSuchAlgorithmException 
	 {  
	        // Static getInstance method is called with hashing SHA  
	        MessageDigest md = MessageDigest.getInstance("SHA-256");  
	  
	        // digest() method called  
	        // to calculate message digest of an input
	        return new String(md.digest(input.getBytes(StandardCharsets.UTF_8)));  
	 }
		
		
	}