package com.example.libraryAmdocs.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryAmdocs.model.IssueTabStruct;
import com.example.libraryAmdocs.repository.ReturnDbOperations;

@Service
public class ReturnService {
	
	@Autowired
	ReturnDbOperations returnCreDb ;
	
	public void returnBookService(IssueTabStruct obj ) throws IOException {
		
		System.out.println();
		returnCreDb.returnDb(obj);
		
	}

}
