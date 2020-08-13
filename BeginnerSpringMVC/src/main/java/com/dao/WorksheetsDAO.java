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
	

	String userName = "Goutham_Mitta";
	String password = "PostgreSQL_2230";
	String hostname = "quizdb.cm6lyukuizi2.us-east-1.rds.amazonaws.com";
	String port = "5432";
	String dbName="quizdb";
	String jdbcUrl = "jdbc:postgresql://"+hostname+":5432/quizdb";
	
	public void addWorksheet() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			
			System.out.println("Got DB connection");
			
			
			//File file = new File("C:\\Users\\Goutham\\WebPageProject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\BeginnerSpringMVC\\resources\\downloads\\Dividing Polynomials.pdf");
			//FileInputStream fis = new FileInputStream(file);
			
			Path pdfPath = Paths.get("C:\\Users\\Goutham\\Documents\\MathDonkey\\Alg1\\ExpGrowthDecay1.pdf");
			byte[] pdf = Files.readAllBytes(pdfPath);
			PreparedStatement ps = con.prepareStatement("insert into sauce2 values(?, ?, ?, ?, ?)");
			ps.setInt(1, 2);
			ps.setString(2, "Algebra1");
			ps.setString(3, "ExpGrowthDecay");
			
			ps.setString(4, "ExpGrowthDecay1.pdf");
			//ps.setBinaryStream(5, fis, (int)file.length());
			ps.setBytes(5, pdf);
			System.out.println(ps.executeUpdate());
			ps.close();
			//fis.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		
	}

	public byte[] getWorksheet(String filename) {
		byte[] bytes=new byte[10];
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			
			System.out.println("Got DB connection");
			
			
			//File file = new File("C:\\Users\\Goutham\\WebPageProject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\BeginnerSpringMVC\\/resources/downloads/Dividing Polynomials.pdf");
			//FileInputStream fis = new FileInputStream(file);
			PreparedStatement ps = con.prepareStatement("select file from sauce2 where title=?");
			ps.setString(1, filename);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bytes = rs.getBytes("file");
				//OutputStream out = new FileOutputStream("C:\\Users\\Goutham\\WebPageProject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\BeginnerSpringMVC\\resources\\downloads\\"+filename+".pdf");
				//OutputStream out = new FileOutputStream("C:\\Users\\Goutham\\WebPageProject\\BeginnerSpringMVC\\src\\main\\webapp\\resources\\downloads\\Dividing Polynomials.pdf");
				
				//out.write(bytes);
				//out.close();
				ps.close();
				return bytes;
			}
			
			ps.close();
			return bytes;
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return bytes;
		} 
		
	}
}
