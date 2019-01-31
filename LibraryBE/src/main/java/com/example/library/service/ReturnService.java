package com.example.library.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.IssueTabStruct;
import com.example.library.repository.ReturnDbOperations;

@Service
public class ReturnService {
	
	@Autowired
	ReturnDbOperations returnCreDb ;
	
	public void returnBookService(IssueTabStruct obj ) throws IOException {
		
		System.out.println();
		returnCreDb.returnDb(obj);
		
	}

}
