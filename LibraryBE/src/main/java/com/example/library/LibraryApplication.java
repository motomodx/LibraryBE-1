package com.example.library;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class LibraryApplication {
	
	   @Value("${spring.application.name}")
	   private String name;
	   public static void main(String[] args) {
		  
	      SpringApplication.run(LibraryApplication.class, args);
	      
	   }
	  
	}  
