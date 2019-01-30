package com.example.library.model;

import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class RequestTabStruct {
	
	String bookId ;
	String memberId;
	String bookName;
	String memberName;
	String requestDate;
	
	public RequestTabStruct() {
		// TODO Auto-generated constructor stub
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
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
