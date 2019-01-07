package com.example.libraryAmdocs.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryAmdocs.model.MemberTabStruct;
import com.example.libraryAmdocs.repository.MemberDbOperations;

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
