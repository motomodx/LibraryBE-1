package com.example.libraryAmdocs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class LibraryAmdocsApplication {
	
	   @Value("${spring.application.name}")
	   private String name;
	   public static void main(String[] args) {
		  
	      SpringApplication.run(LibraryAmdocsApplication.class, args);
	      
	   }
	  
	}  
