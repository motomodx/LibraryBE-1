package com.example.libraryAmdocs.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryAmdocs.model.IssueTabStruct;
import com.example.libraryAmdocs.service.ReturnService;

@RestController
public class ReturnController {
	
	@Autowired
	ReturnService    returnService ;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/returnBook") 
	public void returnBook (IssueTabStruct  obj) throws IOException
	{
		System.out.println("Inside returnBook");
		returnService.returnBookService(obj);
	}
	
}