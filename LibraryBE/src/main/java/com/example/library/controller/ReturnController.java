package com.example.library.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.IssueTabStruct;
import com.example.library.service.ReturnService;

@RestController
public class ReturnController {
	
	@Autowired
	ReturnService    returnService ;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/returnBook",method = RequestMethod.POST)
	public void returnBook ( @RequestBody IssueTabStruct  obj) throws IOException
	{
		System.out.println("Inside returnBook");
		returnService.returnBookService(obj);
	}
	
}
