package com.example.libraryAmdocs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.libraryAmdocs.model.RequestTabStruct ;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


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
	
	public void insertRequest(RequestTabStruct objInpData) throws IOException {
		
		System.out.println("In insertRequest");
		
		String requestInsQuery = "INSERT INTO REQUEST (book_id , member_id , book_name , member_name, request_date) VALUES (? , ?, ?, ?, ?)" ;
		Date todayDate = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String strTodayDate = df.format(todayDate);
		
		try( Connection conn = this.connect() ;
			 PreparedStatement pstmt = conn.prepareStatement(requestInsQuery);	) {
			
			 pstmt.setInt(1, objInpData.getBookId());
			 pstmt.setInt(2, objInpData.getMemberId());
			 pstmt.setString(3, objInpData.getBookName());
			 pstmt.setString(4, objInpData.getMemberName());
			 pstmt.setString(5, strTodayDate);
					
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
	}
		
}


	 
	
