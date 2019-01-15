package com.example.libraryAmdocs.model;

import org.springframework.stereotype.Component;

@Component
public class model {
	String bookName; 
	String owner; 
	String assignTo;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	} 
	
}
