package com.example.libraryAmdocs.model;

import org.springframework.stereotype.Component;


@Component
public class RequestTabStruct {
	
	int bookId ;
	int memberId;
	String bookName;
	String memberName;
	String requestDate;
	
	public RequestTabStruct() {
		// TODO Auto-generated constructor stub
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}	

}
