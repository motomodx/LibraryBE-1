package com.example.libraryAmdocs.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryAmdocs.model.MemberTabStruct;
import com.example.libraryAmdocs.service.memberService;

@RestController
public class memberCotroller {
	
	@Autowired
	memberService    memService ;
	
	@PostMapping("/insMember")

	public void updateMember(MemberTabStruct obj ) throws IOException
	{
		System.out.println("inside updateMember");

		memService.memberUpdateService(obj);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getMem")
	public List<MemberTabStruct> readExcel() throws Exception
	{
		return memService.getMemberRecords();
	}
	

}
