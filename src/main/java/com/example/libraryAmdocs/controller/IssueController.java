package com.example.libraryAmdocs.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import com.example.libraryAmdocs.model.IssueTabStruct;
import com.example.libraryAmdocs.service.IssueService;

@RestController
public class IssueController {
	
	@Autowired
	IssueService issueService ;
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/issueBook")

    public void updateIssue(@RequestBody IssueTabStruct obj ) throws IOException {

		System.out.println("inside updateISsue");

		issueService.issueBookService(obj);
	}
	
	//readIssuesData
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/readIssue")
	public List<IssueTabStruct> readExcel() throws Exception
	{
		return issueService.readIssuesData();
	}
	

}

