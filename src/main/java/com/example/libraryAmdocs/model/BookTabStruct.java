package com.example.libraryAmdocs.model;

import java.sql.Date;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Component;


@Component 
public class BookTabStruct  {

    String bookName;
    int bookID;
    Date bookAddDate;
    boolean bookAvailFlag;
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
	public Date getBookAddDate() {
		return bookAddDate;
	}
	public void setBookAddDate(Date bookAddDate) {
		this.bookAddDate = bookAddDate;
	}
	public boolean getBookAvailFlag() {
		return bookAvailFlag;
	}
	public void setBookAvailFlag(boolean b) {
		this.bookAvailFlag = b;
	}

}
