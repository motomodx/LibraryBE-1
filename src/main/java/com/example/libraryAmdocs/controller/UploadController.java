package com.example.libraryAmdocs.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.libraryAmdocs.model.*;
import com.example.libraryAmdocs.service.UploadService;

@RestController
public class UploadController {

	@Autowired
	UploadService uploadService;
	
	/*
    @CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/readExcel")
	public List<BookTabStruct> readExcel1() throws Exception
	{
		return uploadService.readExcel();
	}
	*/
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/writeExcel")
	public void updateExcel(@RequestBody BookTabStruct obj ) throws IOException 
	{
		uploadService.excelUpdateService(obj);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/readExcel")
	public List<BookTabStruct> readExcel() throws Exception
	{
		return uploadService.readExcel();
	}
	
	
//	@RequestMapping("/hello")
//    public String index() {
//        return "Greetings from Spring Boot!";
//    }
	
//	@PostMapping("/upload")
//	public void upload(@RequestParam("file") MultipartFile file)
//	{
//		UploadService.upload(file);
//	}
	
}
