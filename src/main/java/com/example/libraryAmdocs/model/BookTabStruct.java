package com.example.libraryAmdocs.model;

import java.sql.Date;

import com.sun.org.apache.xpath.internal.operations.Bool;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Component 
public class BookTabStruct  {

    String bookName;
    int bookID;
    String bookAddDate;
    char bookAvailFlag;
    public BookTabStruct() {
		// TODO Auto-generated constructor stub
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	public String getBookAddDate() {
		return bookAddDate;
	}
	public void setBookAddDate(String date) {
		this.bookAddDate = date;
	}
	
	public char getBookAvailFlag() {
		return bookAvailFlag;
	}
	public void setBookAvailFlag(char b) {
		this.bookAvailFlag = b;
	}

}
