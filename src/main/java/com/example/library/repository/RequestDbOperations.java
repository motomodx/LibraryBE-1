package com.example.library.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.sql.Connection;

import com.example.library.model.RequestTabStruct ;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



@Repository
public class RequestDbOperations {
	
	@Autowired
	RequestTabStruct  requestTabRec ;
	
	public Connection connect() {
		
		Connection conn = null ;
		
		try {
			String url = "jdbc:sqlite:C:/SQLite/lib.db";
			conn = DriverManager.getConnection(url) ;
			conn.setAutoCommit(true);
			System.out.println("Database connected");
			
		} catch (SQLException e) {
			
			System.out.println("Database not connected");
			
		}
		
		return conn ;
	}
	
	public List<RequestTabStruct> requestReader() throws IOException {
			 	List<RequestTabStruct> jsonModelArray = new ArrayList<RequestTabStruct>();
			 	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			 	String requestListQuery = "SELECT * FROM REQUEST";
			 	  System.out.println(requestListQuery);
			 	 try (Connection conn = this.connect();
			 		    PreparedStatement pstmt = conn.prepareStatement(requestListQuery)) {

			 		    System.out.println(pstmt);
			 		   
			 		    ResultSet rs = pstmt.executeQuery();
			 		    while(rs.next()) {
			 		    System.out.println("book id = " + rs.getString("book_id"));
			 		    System.out.println("book name = " + rs.getString("book_name"));
			 		    RequestTabStruct requestResult = new RequestTabStruct();
			 		    
//			 		    try {
//			 		      Date today = df.parse(rs.getString("rqst_dt"));
//			 		      System.out.println("Today = " + df.format(today));
//			 		      requestResult.setRequestDate(df.formattoday));
//			 		    } catch (ParseException e) {
//			 		     e.printStackTrace();
//			 		    }
//			 		    
			 		    
			 		    requestResult.setRequestDate(rs.getString("rqst_dt"));
			 		    requestResult.setBookId(rs.getString("book_id"));
			 		   	requestResult.setBookName(rs.getString("book_name"));
			 		   	requestResult.setMemberId(rs.getString("member_id"));
						requestResult.setMemberName(rs.getString("member_name"));
			 		    
			 		    jsonModelArray.add(requestResult);
			 		  		   
			 		    }
			 		  
			 		   System.out.println("Activity logged");
			 		   conn.close();
			 		  } catch (SQLException e) {
			 		   System.out.println(e.getMessage());
			 		   
			 		  }
			 	 
			 	 return jsonModelArray; 
 
  }
	
	public void insertRequest(RequestTabStruct objInpData) throws IOException {
		
		System.out.println("In insertRequest REQUEST");
		
		String requestInsQuery = "INSERT INTO REQUEST (book_id , member_id , book_name , member_name, rqst_dt) VALUES (? , ?, ?, ?, ?)" ;
		
		Date todayDate = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String strTodayDate = df.format(todayDate);
		
		try( Connection conn = this.connect() ;
			 PreparedStatement pstmt = conn.prepareStatement(requestInsQuery);	) {
			
			 pstmt.setString(1, objInpData.getBookId());
			 pstmt.setString(2, objInpData.getMemberId());
			 pstmt.setString(3, objInpData.getBookName());
			 pstmt.setString(4, objInpData.getMemberName());
			 pstmt.setString(5, strTodayDate);
			 //have to fetch sysdate and then convert to string to replace the hardcode 
			 pstmt.executeUpdate();
			System.out.println("Insert Executed REQUEST");
		} catch (SQLException e) {
			
		  System.out.println(e.getMessage());	
			
		}
	}
	
	
      
 }
		


	 
	
