package com.example.libraryAmdocs.repository;

import java.io.IOException;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.libraryAmdocs.model.IssueTabStruct;

@Repository 
public class IssueDbOperations {
	
	@Autowired
	IssueTabStruct   issueRec ;
	
	public Connection connect () {
		
		Connection conn = null ;
		
		try {
			 String url = "jdbc:sqlite:C:/SQLite/lib.db";
			 conn = DriverManager.getConnection(url);
			 conn.setAutoCommit(true);
			 
			 System.out.println("Database Connected");
			
		} catch (SQLException e) {
		  System.out.println("Database not connected");
		  System.out.println(e.getMessage());
		}
		
		return conn ;
	}
	
	public List<IssueTabStruct> issueReader() throws IOException {
	 	List<IssueTabStruct> jsonModelArray = new ArrayList<IssueTabStruct>();
	 	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	 	String issueListQuery = "SELECT * FROM ISSUE";
	 	  System.out.println(issueListQuery);
	 	 try (Connection conn = this.connect();
	 		    PreparedStatement pstmt = conn.prepareStatement(issueListQuery)) {

	 		    System.out.println(pstmt);
	 		   
	 		    ResultSet rs = pstmt.executeQuery();
	 		    while(rs.next()) {
	 		    System.out.println("book id = " + rs.getString("book_id"));
	 		    System.out.println("book name = " + rs.getString("book_name"));
	 		    IssueTabStruct issueResult = new IssueTabStruct();
//	 		    try {
//	 		      Date today = df.parse(rs.getString("issue_date"));
//	 		      System.out.println("Today = " + df.format(today));
//	 		      issueResult.setIssueDate(df.format(today));
//	 		    } catch (ParseException e) {
//	 		     e.printStackTrace();
//	 		    }
	 		    	 		    
	 		    issueResult.setIssueDate(rs.getString("issuedate"));
	 		    issueResult.setBookId(rs.getString("book_id"));
	 		   	issueResult.setBookName(rs.getString("book_name"));
	 		   	issueResult.setMemberId(rs.getString("member_id"));
				issueResult.setMemberName(rs.getString("member_name"));
	 		    
	 		    jsonModelArray.add(issueResult);
	 		  		   
	 		    }
	 		  
	 		   System.out.println("Activity logged");
	 		   conn.close();
	 		  } catch (SQLException e) {
	 		   System.out.println(e.getMessage());
	 		   
	 		  }
	 	 
	 	 return jsonModelArray; 

}
	
	
	public void issueDb(IssueTabStruct obj) {
		
		String issueInsQuery = "INSERT INTO ISSUE (BOOK_ID, MEMBER_ID, BOOK_NAME, MEMBER_NAME,ISSUEDATE) VALUES (?, ?, ?, ?,?)" ;
		//issue_date is missing
		String updBookQuery = "UPDATE BOOKS SET AVAL_FLAG = 'N' WHERE BOOK_ID = ?" ;
		String updMemberQuery = "UPDATE MEMBER SET ISSUEDFLAG = 'N' WHERE MEMBER_ID = ? " ;
		String delRequestQuery = "DELETE FROM REQUEST WHERE BOOK_ID = ? AND MEMBER_ID = ? " ;
		
		Date todayDate = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String strTodayDate = df.format(todayDate);
		
		try {
		Connection conn = this.connect() ;
		PreparedStatement insStmt = conn.prepareStatement(issueInsQuery);
		
		insStmt.setString(1, obj.getBookId());
		insStmt.setString(2, obj.getMemberId());
		insStmt.setString(3, obj.getBookName());
		insStmt.setString(4, obj.getMemberName());
		insStmt.setString(5, strTodayDate);
		System.out.println(insStmt);
		
		insStmt.executeUpdate();
		
		PreparedStatement upBookStmt = conn.prepareStatement(updBookQuery);
		upBookStmt.setString(1, obj.getBookId());
		
		System.out.println(upBookStmt);
		
		upBookStmt.executeUpdate();
		
		PreparedStatement upMemberStmt = conn.prepareStatement(updMemberQuery) ;
		upMemberStmt.setString(1, obj.getMemberId());
		
		System.out.println(upMemberStmt);
		
		upMemberStmt.executeUpdate();
		
		PreparedStatement delReqStmt = conn.prepareStatement(delRequestQuery);
		delReqStmt.setString(1, obj.getBookId());
		delReqStmt.setString(2, obj.getMemberId());
		
		System.out.println(delReqStmt);
		
		delReqStmt.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
