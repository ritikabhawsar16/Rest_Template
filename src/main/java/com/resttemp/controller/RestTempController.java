package com.resttemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/resttemp")
public class RestTempController {
	
	@Autowired
	public RestTemplate restTemplate;

	@GetMapping("/studentresttemp")
	public ResponseEntity<String> getStudent()
	{
		System.out.println("Calling Local Third Party API...");
		ResponseEntity<String> response=restTemplate.exchange("http://localhost:9092/getAllStudent", HttpMethod.GET,null,String.class);
		System.out.println(response.getBody());
		
		return new ResponseEntity<String>(response.getBody(),HttpStatus.OK);
	}
	
	@GetMapping("/employeeresttemp")
	public ResponseEntity<String> getEmployee()
	{
		System.out.println("Calling Local Third Party API...!!!");
		ResponseEntity<String> response=restTemplate.exchange("http://192.168.1.4:8042/getAllEmployee", HttpMethod.GET,null,String.class);
		System.out.println(response.getBody());
		
		return new ResponseEntity<String>(response.getBody(),HttpStatus.OK);
	}
	
}
