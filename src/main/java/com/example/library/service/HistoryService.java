package com.example.library.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.HistoryTabStruct;
import com.example.library.repository.HistoryDbOperations;

@Service
public class HistoryService {
	
	@Autowired
	HistoryDbOperations bookHistList ;
	
	public List<HistoryTabStruct> bookHistoryService() throws IOException {
		
		System.out.println("In bookHistoryService");
		return bookHistList.returnBookHistory() ;
	}
	

}
