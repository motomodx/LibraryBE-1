package com.example.libraryAmdocs.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.libraryAmdocs.model.HistoryTabStruct;
import com.example.libraryAmdocs.model.IssueTabStruct;

@Repository
public class ReturnDbOperations {
	
	@Autowired
	HistoryTabStruct    historyTabRec ;
	
	public Connection connect() {
		
		Connection conn = null ;
		
		
		try {
			String url = "jdbc:sqlite:C:/SQLite/lib.db";
			conn = DriverManager.getConnection(url) ;
			conn.setAutoCommit(true);
			
			System.out.println("Database Connected");
			
		} catch (SQLException e) {
			System.out.println("Not Connected to database");
			System.out.println(e.getMessage());
		}
		
		return conn ;
	}
	
	public void returnDb (IssueTabStruct objInpData) {
		
		System.out.println("Inside returnBook ");
		
		String insHisQuery = "INSERT INTO BOOK_HISTORY (BOOK_ID, MEMBER_ID, BOOK_NAME, MEMBER_NAME, ISSUE_DATE, SUBMIT_DATE) VALUES (?, ?, ?, ?, ?, ?) ";
		String updBookQuery = "UPDATE BOOK SET BOOK_AVAILABLE = 'Y' WHERE BOOK_ID = (?)";
		String updMemberQuery = "UPDATE MEMBER SET ISSUED_STATUS = 'N' WHERE MEMBER_ID = (?)";
		String delRequestQuery = "DELETE FROM BOOK_ISSUE WHERE BOOK_ID = (?) AND MEMBER_ID = (?)";
		
		Date todayDate = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String strTodayDate = df.format(todayDate);
		
		try {
			Connection conn = this.connect();
			PreparedStatement insHisStmt = conn.prepareStatement(insHisQuery);
			
			insHisStmt.setInt(1, objInpData.getBookId());
			insHisStmt.setInt(2, objInpData.getMemberId());
			insHisStmt.setString(3, objInpData.getBookName());
			insHisStmt.setString(4, objInpData.getMemberName());
			insHisStmt.setString(5, objInpData.getIssueDate());
			insHisStmt.setString(6, strTodayDate);
			
			System.out.println(insHisStmt);
			
			insHisStmt.executeUpdate();
			
			PreparedStatement upBookStmt = conn.prepareStatement(updBookQuery);
			upBookStmt.setInt(1, objInpData.getBookId());
			
			System.out.println(upBookStmt);
			
			upBookStmt.executeUpdate();
			
			PreparedStatement upMemberStmt = conn.prepareStatement(updMemberQuery);
			upMemberStmt.setInt(1, objInpData.getMemberId());
			
            System.out.println(upMemberStmt);
			
            upMemberStmt.executeUpdate();
            
            PreparedStatement delRequestStmt = conn.prepareStatement(delRequestQuery);
            delRequestStmt.setInt(1, objInpData.getBookId());
            delRequestStmt.setInt(2, objInpData.getMemberId());
            
            System.out.println(delRequestStmt);
            
            delRequestStmt.executeUpdate() ;

			} catch (SQLException e) {
			   System.out.println(e.getMessage());
			}
				
	}

}
