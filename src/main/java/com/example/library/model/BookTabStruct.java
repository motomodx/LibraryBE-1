package com.example.library.model;

import java.sql.Date;

import com.sun.org.apache.xpath.internal.operations.Bool;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Component 
public class BookTabStruct  {

    String bookName;
    String bookID;
    String bookAddDate;
    String bookAvailFlag;
    public BookTabStruct() {
		// TODO Auto-generated constructor stub
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	
	public String getBookAddDate() {
		return bookAddDate;
	}
	public void setBookAddDate(String date) {
		this.bookAddDate = date;
	}
	
	public String getBookAvailFlag() {
		return bookAvailFlag;
	}
	public void setBookAvailFlag(String b) {
		this.bookAvailFlag = b;
	}

}
