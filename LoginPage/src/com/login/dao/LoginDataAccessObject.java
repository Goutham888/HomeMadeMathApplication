package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.data.User;
import com.util.UtilMethods;

public class LoginDataAccessObject {
	
	UtilMethods utilMethods = new UtilMethods();
	
	String sqlLogin = "select * from login where username=? and passcode=?";
	String sqlLog = "insert into loginattempts (username, passcode, loginsuccess, currentlogin, lastloggedin) values (?, ?, ?, ?, ?)";
	String sqlCheckLast = "select currentlogin from loginattempts where username=? and loginsuccess='y' order by currentlogin desc";
	String sqlGetAll = "select * from login";
	public boolean check(String uname, String pass) {
		
		try {
			
			Connection con = utilMethods.establishConnection();
			PreparedStatement st = con.prepareStatement(sqlLogin);
			
			st.setString(1, uname);
			
			String encrypted = utilMethods.getSHA(pass);
			st.setString(2, encrypted);
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return false;
	}
	
	public void log(String uname, String pass, String success) {
		try {
			
			Connection con = utilMethods.establishConnection();
			PreparedStatement checkLast = con.prepareStatement(sqlCheckLast);
			
			checkLast.setString(1,uname);
			ResultSet checkLastResult = checkLast.executeQuery();
			Timestamp lastLogin = null;	
			if(checkLastResult.next()) {
				lastLogin = checkLastResult.getTimestamp("currentlogin");
			}
			
			java.sql.Timestamp currentTimestamp = utilMethods.getCurrentTime();
			
			PreparedStatement enterLog = con.prepareStatement(sqlLog);
			enterLog.setString(1, uname);
			
			String encrypted = utilMethods.getSHA(pass);
			
			enterLog.setString(2, encrypted);
			enterLog.setString(3, success);
			enterLog.setTimestamp(4, currentTimestamp);
			enterLog.setTimestamp(5, lastLogin);
			
			enterLog.executeUpdate();
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			
			Connection con = utilMethods.establishConnection();
			PreparedStatement getAll = con.prepareStatement(sqlGetAll);
			ResultSet rs = getAll.executeQuery();
			User temp = new User();
			while(rs.next()) {
				temp.setFirstName(rs.getString("firstname"));
				temp.setLastName(rs.getString("lastname"));
				temp.setUserName(rs.getString("username"));
				users.add(temp);
				temp = new User();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return users;
		
	}
}