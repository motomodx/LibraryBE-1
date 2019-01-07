package com.example.libraryAmdocs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryAmdocs.repository.RequestDbOperations ;

@Service
public class RequestService {
	
	@Autowired
	RequestDbOperations requestDb ;

}
