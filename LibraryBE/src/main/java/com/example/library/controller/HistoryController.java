package com.example.library.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.HistoryTabStruct;
import com.example.library.service.HistoryService;

@RestController
public class HistoryController {
	
	@Autowired
	HistoryService historyService ;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/readHistory")
	
	public List<HistoryTabStruct> bookHistory() throws IOException{
		return historyService.bookHistoryService();
	}
}
