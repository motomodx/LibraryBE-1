package com.example.libraryAmdocs.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryAmdocs.model.BookTabStruct;
import com.example.libraryAmdocs.model.IssueTabStruct;
import com.example.libraryAmdocs.repository.IssueDbOperations;

@Service
public class IssueService {
	
	@Autowired
	IssueDbOperations issueCreDb ;
	
	public void issueService(IssueTabStruct obj) throws IOException {
		System.out.println("InsideexcelUpdateService ");
		issueCreDb.issueDb(obj);
	}
	public List<IssueTabStruct> readIssuesData() throws IOException {
		return issueCreDb.issueReader();
	}
	
	//issueReader
	

}
