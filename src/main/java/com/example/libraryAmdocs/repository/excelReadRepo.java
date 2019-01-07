package com.example.libraryAmdocs.repository;

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
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.libraryAmdocs.model.BookTabStruct;





@Repository
public class excelReadRepo {
	
	@Autowired 
	BookTabStruct excelJson;
	
	public Connection connect() {
			  
		  Connection conn = null;
		  try {
			  String url = "jdbc:sqlite:C:/SQLite/lib.db";
			  conn = DriverManager.getConnection(url);
			  conn.setAutoCommit(true);
			  System.out.println("Connected to database");
		  } catch (SQLException e) {
			  System.out.println("Not Connected to database");
		    }
		  return conn;
	}

	
	
	public List<BookTabStruct> bookReader() throws IOException {
			 	List<BookTabStruct> excelJsonModelArray = new ArrayList<BookTabStruct>();
			 	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			 	String bookListQuery = "SELECT * FROM BOOKS";
			 	  System.out.println(bookListQuery);
			 	 try (Connection conn = this.connect();
			 		    PreparedStatement pstmt = conn.prepareStatement(bookListQuery)) {

			 		    System.out.println(pstmt);
			 		   
			 		    ResultSet rs = pstmt.executeQuery();
			 		    while(rs.next()) {
			 		    System.out.println("book id = " + rs.getString("book_id"));
			 		    System.out.println("book name = " + rs.getString("book_name"));
			 		    BookTabStruct bookResult = new BookTabStruct();
			 		    try {
			 		      Date today = df.parse(rs.getString("add_date"));
			 		      System.out.println("Today = " + df.format(today));
			 		      bookResult.setBookAddDate(df.format(today));
			 		    } catch (ParseException e) {
			 		     e.printStackTrace();
			 		    }
			 		    	 		    
			 		    
			 		    bookResult.setBookID(rs.getInt("book_id"));
			 		   	bookResult.setBookName(rs.getString("book_name"));
			 		   	bookResult.setBookAvailFlag(rs.getString("aval_flag").charAt(0));
			 		    
			 		    excelJsonModelArray.add(bookResult);
			 		  		   
			 		    }
			 		  
			 		   System.out.println("Activity logged");
			 		   conn.close();
			 		  } catch (SQLException e) {
			 		   System.out.println(e.getMessage());
			 		   
			 		  }
			 	 
			 	 return excelJsonModelArray; 
 
  }
		
	
    public void excelUpdater(BookTabStruct objInpData) throws IOException {
    	System.out.println("Inside excel updater");
    	
    	String bookInsertQuery = "INSERT INTO BOOKS(book_id,book_name, add_date, aval_flag) VALUES(?,?,?,?)";
    	String bookIdGetQuery = "select max(book_id) max_book_id from books";
    	int new_book_id = 0;
    	try (Connection conn = this.connect();
	 		    PreparedStatement pstmt = conn.prepareStatement(bookIdGetQuery)) {
    	ResultSet rs = pstmt.executeQuery();
    	System.out.println("current book id = " + rs.getInt("max_book_id"));
    	new_book_id = rs.getInt("max_book_id")+1;
    	System.out.println("new book id =" + new_book_id);
    	//Connection conn1 = this.connect();
    	
    	System.out.println("Input book name = " + objInpData.getBookName() );
    	System.out.println("Input Book Add date = " + objInpData.getBookAddDate() );
    	System.out.println("Input Flag = " + String.valueOf(objInpData.getBookAvailFlag()) );
    	
    	
    	PreparedStatement bookIdInsertStatement = conn.prepareStatement(bookInsertQuery);
    	bookIdInsertStatement.setInt(1,new_book_id);
    	bookIdInsertStatement.setString(2, objInpData.getBookName());
    	bookIdInsertStatement.setString(3, objInpData.getBookAddDate());
    	bookIdInsertStatement.setString(4, String.valueOf(objInpData.getBookAvailFlag()));
    	    	
    	//bookIdInsertStatement.setString
    	System.out.println(bookIdInsertStatement);
    	bookIdInsertStatement.executeUpdate();
    	System.out.println("Insert Executed");
    	}catch (SQLException e) {
	 		   System.out.println(e.getMessage());
 	   }
      
 }
}
