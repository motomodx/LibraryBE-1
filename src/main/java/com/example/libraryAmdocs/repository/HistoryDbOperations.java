package com.example.libraryAmdocs.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.libraryAmdocs.model.HistoryTabStruct;

@Repository
public class HistoryDbOperations {
	
	@Autowired
	HistoryTabStruct historyDb ;
	
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
    
    public List<HistoryTabStruct> returnBookHistory() throws IOException {
		List<HistoryTabStruct> returnBookList = new ArrayList<HistoryTabStruct>();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		String returnListQuery = "SELECT * FROM HISTORY" ;
		
		try (Connection conn = this.connect();
				 PreparedStatement pstmt = conn.prepareStatement(returnListQuery);) {
				
				System.out.println(pstmt);
				
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					System.out.println("book id = " + rs.getString("book_id"));
					System.out.println("book name = " + rs.getString("book_name"));
					
					HistoryTabStruct historyResult = new HistoryTabStruct();
					
					historyResult.setBookId(rs.getString("book_id"));
					historyResult.setBookName(rs.getString("book_name"));
					historyResult.setIssueDate(rs.getString("issuedate"));
					historyResult.setMemberId(rs.getString("member_id"));
					historyResult.setMemberName(rs.getString("member_name"));
		 		    historyResult.setSubmitDate(rs.getString("submitdate"));
					returnBookList.add(historyResult);
				}
				System.out.println("Activity logged");
		 		   conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		   return returnBookList;
    }

}
