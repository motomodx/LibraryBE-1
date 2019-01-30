package com.example.library.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.MemberTabStruct;
import com.example.library.repository.MemberDbOperations;

@Service
public class memberService {
	
	@Autowired
	MemberDbOperations memberDb ;
	
	public List<MemberTabStruct> getMemberRecords() throws IOException {
		return memberDb.getAllMembers();
	}
	
	public void memberUpdateService(MemberTabStruct obj) throws IOException {
		System.out.println("Inside memberUpdateService ");
		memberDb.insertMember(obj);
	}
	


}
