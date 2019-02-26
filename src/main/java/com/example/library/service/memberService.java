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
	
	public void memberUpdateService(MemberTabStruct obj, String reqFlag) throws IOException {
		System.out.println("Inside memberUpdateService ");
		if (reqFlag.equals("I")) {
			System.out.println("Flag received as Insert ");
			memberDb.insertMember(obj);
		} else if (reqFlag.equals("U")) {
			System.out.println("Flag received as Update ");
			memberDb.updateMember(obj);
			}
		else if (reqFlag.equals("D")) {
			System.out.println("Flag received as Delete ");
			memberDb.deleteMember(obj);
		}
		else {
			System.out.println("Invalid request ");
		
		}
	}
	


}
