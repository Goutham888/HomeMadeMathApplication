package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.UtilMethods;

public class SignUpDAO {
	
	String sql = "insert into login (username, passcode, firstname, lastname) values (?, ?, ?, ?)";
	String url = "jdbc:oracle:thin:@localhost:1521/orcl.fios-router.home";
	String username = "c##goutham";
	String password = "Oracle_2020";
	
	UtilMethods utilMethods = new UtilMethods();
	public boolean updateRecords(String uname, String pass, String firstName, String lastName) {
		
		try {
			
			Connection con = utilMethods.establishConnection();
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setString(1, uname);
			
			String encrypted = utilMethods.getSHA(pass);
			
			st.setString(2, encrypted);
			st.setString(3, firstName);
			st.setString(4, lastName);
			
			st.executeUpdate();
			System.out.println("hey");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return false;
	}
}
