package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Category;
import com.example.demo.services.ICategoryServices;

@CrossOrigin
@RestController
public class CategoryController {
	
	@Autowired
	ICategoryServices iCategoryServices;
	
	@GetMapping("/categories")
	public ResponseEntity<?> findAll() {
		Map<String, Object> response = new HashMap<>();
		List<Category> categories = new ArrayList<>();
		
		try {
			
			categories = iCategoryServices.findAll();
		}catch(Exception e) {
			response.put("error", "Something has happened finding the categories. Please try again later.");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
		}
			
		response.put("success", categories);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK); 
	}
}
