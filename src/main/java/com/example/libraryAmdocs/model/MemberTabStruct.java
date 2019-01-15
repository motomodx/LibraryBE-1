package com.example.libraryAmdocs.model;

import org.springframework.stereotype.Component;

@Component
public class MemberTabStruct {
	
	String memberId ;
	String memberName;
	String EmailId;
	String ContactNum;
	String  IssuedFlag;
	
	public MemberTabStruct() {
		// TODO Auto-generated constructor stub
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		this.EmailId = emailId;
	}
	public String getContactNum() {
		return ContactNum;
	}
	public void setContactNum(String contactNum) {
		this.ContactNum = contactNum;
	}
	public String getIssuedFlag() {
		return IssuedFlag;
	}
	public void setIssuedFlag(String string) {
		this.IssuedFlag = string;
	} 	

}
