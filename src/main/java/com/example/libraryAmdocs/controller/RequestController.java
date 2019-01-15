package com.example.libraryAmdocs.controller;



import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryAmdocs.model.BookTabStruct;
import com.example.libraryAmdocs.model.RequestTabStruct;
import com.example.libraryAmdocs.service.RequestService ;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class RequestController {
	
	@Autowired
	RequestService requestServiceRec ;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/readRqst")
	public List<RequestTabStruct> readRequest() throws Exception
	{
		return requestServiceRec.readRequestData();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/writeRqst",method = RequestMethod.POST) 
	public void writeRequest(@RequestBody RequestTabStruct obj ) throws Exception
	{
		 requestServiceRec.writeRequestData(obj);
	}	
	


}
