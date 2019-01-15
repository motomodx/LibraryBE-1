package com.example.libraryAmdocs.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryAmdocs.model.RequestTabStruct;
import com.example.libraryAmdocs.repository.RequestDbOperations ;

@Service
public class RequestService {
	
	@Autowired
	RequestDbOperations requestDb ;
	
	public List<RequestTabStruct> readRequestData() throws IOException {
		return requestDb.requestReader();
	}
    
	public void writeRequestData(RequestTabStruct obj) throws IOException
	{
		System.out.println("InsideexcelUpdateService ");
		requestDb.insertRequest(obj);
	}
}
