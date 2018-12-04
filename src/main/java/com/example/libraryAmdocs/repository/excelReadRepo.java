package com.example.libraryAmdocs.repository;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.sql.Connection;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
			  System.out.println("Connected to database");
		  } catch (SQLException e) {
			  System.out.println("Not Connected to database");
		    }
		  return conn;
	}

	
	
	public List<BookTabStruct> excelReader() throws IOException {
			 	List<BookTabStruct> excelJsonModelArray = new ArrayList<BookTabStruct>();
			 	String bookListQuery = "SELECT * FROM BOOKS";
			 	  System.out.println(bookListQuery);
			 	 try (Connection conn = this.connect();
			 		    PreparedStatement pstmt = conn.prepareStatement(bookListQuery)) {

			 		    System.out.println(pstmt);
			 		   
			 		    ResultSet rs = pstmt.executeQuery();
			 		    while(rs.next()) {
			 		    System.out.println("book id = " + rs.getString("book_id"));
			 		    System.out.println("book name = " + rs.getString("book_name"));
			 		  // System.out.println(rs.getDate("add_date"));
			 		    BookTabStruct bookResult = new BookTabStruct();
			 		    
			 		    bookResult.setBookID(rs.getInt("book_id"));
			 		   	bookResult.setBookName(rs.getString("book_name"));
			 		   	bookResult.setBookAvailFlag(rs.getBoolean("aval_flag"));
			 		   	//bookResult.setBookAddDate(rs.getDate("add_date"));
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
    	String bookInsertQuery = "INSERT INTO BOOKS(book_id,book_name, aval_flag, add_date) VALUES(?,?,?,?)";
    	String bookIdGetQuery = "SELECT MAX(BOOK_ID) from BOOKS";
    			int new_book_id = 0;
    	try (Connection conn = this.connect();
	 		    PreparedStatement pstmt = conn.prepareStatement(bookIdGetQuery)) {
    		ResultSet rs = pstmt.executeQuery();
    		System.out.println("current book id = " + rs.getInt("book_id"));
    		new_book_id = rs.getInt("book_id")+1;
        }catch (SQLException e) {
	 		   System.out.println(e.getMessage());
    	   }
 }
}
