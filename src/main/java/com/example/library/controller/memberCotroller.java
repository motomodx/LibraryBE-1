package com.example.library.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.BookTabStruct;
import com.example.library.model.IssueTabStruct;
import com.example.library.model.MemberTabStruct;
import com.example.library.service.memberService;

@RestController
public class memberCotroller {
	
	@Autowired
	memberService memService ;
		
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/writeMember",method = RequestMethod.POST) 
	public void updateMember(@RequestBody MemberTabStruct obj, String reqFlag) throws IOException
	{
		System.out.println("inside updateMember");
		memService.memberUpdateService(obj, reqFlag);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/readMem")
	public List<MemberTabStruct> readExcel() throws Exception
	{
		return memService.getMemberRecords();
	}
	

}
