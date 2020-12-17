package com.dao;

import java.io.File;
import java.nio.file.Files;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.postgresql.util.ByteBufferByteStreamWriter;
import org.springframework.stereotype.Component;

@Component
public class WorksheetsDAO {
	/* FOR ORACLE
	 * String url = "jdbc:oracle:thin:@:1521/orcl.fios-router.home";
	String username = "c##goutham";
	String password = "Oracle_2020";*/
	//The above comment is for oracle, I don't use this DB anymore but its information is here just
	//in case I have to move back
	
	//This is the login information for the current DB don't steal it
	String userName = "postgres";
	String password = "PostgreSQL_2230?";
	String hostname = "localhost";
	String port = "5433";
	String dbName="postgres";
	String jdbcUrl = "jdbc:postgresql://"+hostname+":"+port+"/"+dbName;
	
	//These are datafields made for the getStats() function
	int[] stats = new int[]{0,0,0,0};
	int alg1Stat = 0;
	int trigStat=0;
	int alg2Stat=0;
	int calcABStat = 0;
	
	//A method to get the statistics for what worksheets are in the database
	public int[] getStats() {
		try {//Java forced me to do this to avoid Exceptions from the DB
			//Making the connection, soon this will be offloaded under the com.util package
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			
			//Just confirming the connection
			System.out.println("Got DB connection");
			
			//A statement selecting id's where the family is Algebra 1
			//I chose to select id's b/c it's probably the fastest to pull from the db
			PreparedStatement ps = con.prepareStatement("select id from worksheets where family=?");
			ps.setString(1, "Algebra1");
			
			//I execute the query and count the results
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				alg1Stat++;
			}
			
			//A statement selecting id's where the family is Trig
			//I chose to select id's b/c it's probably the fastest to pull from the db
			PreparedStatement ps2 = con.prepareStatement("select id from worksheets where family=?");
			ps2.setString(1, "Trig");
			
			//I execute the query and count the results
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()) {
				trigStat++;
			}
			
			//A statement selecting id's where the family is Algebra 2
			//I chose to select id's b/c it's probably the fastest to pull from the db
			PreparedStatement ps3 = con.prepareStatement("select id from worksheets where family=?");
			ps3.setString(1, "Algebra2");
			
			//I execute the query and count the results
			ResultSet rs3 = ps3.executeQuery();
			while(rs3.next()) {
				alg2Stat++;
			}
			
			//A statement selecting id's where the family is Calculus AB
			//I chose to select id's b/c it's probably the fastest to pull from the db
			PreparedStatement ps4 = con.prepareStatement("select id from worksheets where family=?");
			ps4.setString(1, "CalcAB");
			
			//I execute the query and count the results
			ResultSet rs4 = ps4.executeQuery();
			while(rs4.next()) {
				calcABStat++;
			}
			
			//I assign the values that I counted to the parts of stats to send it out
			stats[1]=trigStat;
			stats[2]=alg2Stat;
			stats[3]=calcABStat;
			stats[0]=alg1Stat;
			
			//I reset the values just in case I need it again
			alg1Stat = 0;
			trigStat=0;
			alg2Stat=0;
			calcABStat = 0;
			
			//return my result
			return stats;
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//I still wanna return stats even if stuff goes wrong
				return stats;
		} 
	}
	
	//A method to pull and return the worksheet from the database as a byte array
	public byte[] getWorksheet(String filename) {
		//This is just instantiating the byte array. 
		//I give it a length of 10 but it's replaced later on so it doesn't matter
		byte[] bytes=new byte[10];
		try {
			//Just setting up the connection
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			
			//Making sure the connection happened
			System.out.println("Got DB connection");
			
			//Calling the pdf's from the DB where filename watches
			PreparedStatement ps = con.prepareStatement("select pdf from worksheets where filename=?");
			//replace the ? with the right filename
			ps.setString(1, filename);
			
			//Executed the query
			ResultSet rs = ps.executeQuery();
			//if there is a result, I'm setting the byte array to the result of the query
			if(rs.next()) {
				bytes = rs.getBytes("pdf");
				//closing my statement
				ps.close();
				//returning the array
				return bytes;
			}
			//If the query doesn't return anything, still close it
			ps.close();
			return bytes;
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return the empty byte array if the connection doesn't happen
			return bytes;
		} 
		
	}
	
	//A method to add a worksheet to the database
	//To be fair, this method doesn't have an official implementation
	//It's called by the Testing.jsp 
	public void addWorksheet() {
		try {
			//creating the database connection
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			
			//confirming the DB connection
			System.out.println("Got DB connection");
			
			//Set the path for the pdf to upload
			//In the actual implementation I have to find a way to automate this or at least standardize where it's coming from
			Path pdfPath = Paths.get("C:\\Users\\Goutham\\Documents\\UVA stuff\\STS_stff\\TechDesc\\BottleLidTechnicalDescriptionFinal.pdf");
			
			//Converting the file into bytes b/c that's how it's stored in the DB 
			byte[] pdf = Files.readAllBytes(pdfPath);
			
			//Creating the prepared statement with all the columns filled in 
			PreparedStatement ps = con.prepareStatement("insert into worksheets values(?, ?, ?, ?, ?)");
			
			//Just filling in all the columns, id, family, topic, filename, file
			ps.setInt(1, 1);
			ps.setString(2, "Algebra1");
			ps.setString(3, "ExpGrowthDecay");
			
			ps.setString(4, "TestDocument.pdf");
			ps.setBytes(5, pdf);
			
			//executing the update
			System.out.println(ps.executeUpdate());
			
			//closing the query
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//don't do anything if something goes wrong up there
		} 
		
	}

	
}
