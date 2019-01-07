package com.example.libraryAmdocs.model;

import org.springframework.stereotype.Component;

@Component
public class MemberTabStruct {
	
	int memberId ;
	String memberName;
	String emailId;
	String contactNum;
	char   issuedFlag;
	
	public MemberTabStruct() {
		// TODO Auto-generated constructor stub
	}
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public char getIssuedFlag() {
		return issuedFlag;
	}
	public void setIssuedFlag(char issuedFlag) {
		this.issuedFlag = issuedFlag;
	} 	

}
