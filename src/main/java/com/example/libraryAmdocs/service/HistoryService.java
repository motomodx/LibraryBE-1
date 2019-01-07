package com.example.libraryAmdocs.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryAmdocs.model.HistoryTabStruct;
import com.example.libraryAmdocs.repository.HistoryDbOperations;

@Service
public class HistoryService {
	
	@Autowired
	HistoryDbOperations bookHistList ;
	
	public List<HistoryTabStruct> bookHistoryService() throws IOException {
		
		System.out.println("In bookHistoryService");
		return bookHistList.returnBookHistory() ;
	}
	

}
