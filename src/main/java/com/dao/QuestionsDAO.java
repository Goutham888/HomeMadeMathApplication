package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;

@Component
public class QuestionsDAO {
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
	
	public String getQuestion(int id) {
		String ret = "";
		
		
	
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			
			System.out.println("Got DB connection");
			PreparedStatement st = con.prepareStatement("select * from quiztable where id=?");
			
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			System.out.println("Query is executed");
			
			if(rs.next()) {
				ret = rs.getString("requests");
			}
			return ret;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ret;
		} 
		
	}
	public int checkQA(String response, String question) {
		int ret = 0;
		
	
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			
			System.out.println("Got DB connection");
			PreparedStatement st = con.prepareStatement("select * from quiztable where requests=?");
			
			st.setString(1, question);
			
			ResultSet rs = st.executeQuery();
			System.out.println("Query is executed");
			
			if(rs.next()) {
				if(rs.getString("responses").equals(response)){
					ret=1;
				}
			}
			return ret;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ret;
		} 
		
	}
}
