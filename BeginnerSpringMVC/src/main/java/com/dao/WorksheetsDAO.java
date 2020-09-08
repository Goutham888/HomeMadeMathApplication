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
	int[] stats = new int[]{0,0,0,0};
	int alg1Stat = 0;
	int trigStat=0;
	int alg2Stat=0;
	int calcABStat = 0;
	
	public int[] getStats() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			
			System.out.println("Got DB connection");
			
			PreparedStatement ps = con.prepareStatement("select file from sauce2 where course=?");
			ps.setString(1, "Algebra1");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				alg1Stat++;
			}
			
			PreparedStatement ps2 = con.prepareStatement("select file from sauce2 where course=?");
			ps2.setString(1, "Trig");
			
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()) {
				trigStat++;
			}
			
			PreparedStatement ps3 = con.prepareStatement("select file from sauce2 where course=?");
			ps3.setString(1, "Algebra2");
			
			ResultSet rs3 = ps3.executeQuery();
			while(rs3.next()) {
				alg2Stat++;
			}
			
			PreparedStatement ps4 = con.prepareStatement("select file from sauce2 where course=?");
			ps4.setString(1, "CalcAB");
			
			ResultSet rs4 = ps4.executeQuery();
			while(rs4.next()) {
				calcABStat++;
			}
			
			stats[1]=trigStat;
			stats[2]=alg2Stat;
			stats[3]=calcABStat;
			stats[0]=alg1Stat;
			
			alg1Stat = 0;
			trigStat=0;
			alg2Stat=0;
			calcABStat = 0;
			
			return stats;
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return stats;
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

	
}
