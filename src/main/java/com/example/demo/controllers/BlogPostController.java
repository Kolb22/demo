package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.BlogPostTO;
import com.example.demo.models.BlogPost;
import com.example.demo.services.IBlogPostService;

@CrossOrigin
@RestController
public class BlogPostController {
	
	@Autowired
	IBlogPostService iBlogPostService;
	
	@PostMapping("/posts")
	public ResponseEntity<?> create(@RequestBody BlogPostTO blogPostTO ) {
		Map<String, Object> response = new HashMap<>();
		BlogPost blogPost = new BlogPost();
		
		try {
			
			blogPost = iBlogPostService.create(blogPostTO);
		}catch(Exception e) {
			response.put("error", "Something has happened saving the Blog Post. Please try again later.");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
		}
			
		response.put("success", blogPost);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK); 
	}
	
	@GetMapping("/posts")
	public ResponseEntity<?> findAll() {
		Map<String, Object> response = new HashMap<>();
		List<BlogPost> blogPosts = new ArrayList<>();
		
		try {
			
			blogPosts = iBlogPostService.findAll();
		}catch(Exception e) {
			response.put("error", "Something has happened finding the Blog Posts. Please try again later.");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
		}
			
		response.put("success", blogPosts);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK); 
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<?> findById(@PathVariable String id) {
		Map<String, Object> response = new HashMap<>();
		BlogPost blogPost = new BlogPost();
		
		try {
			
			blogPost = iBlogPostService.findById(Long.parseLong(id));
			
			if(blogPost == null) {
				response.put("No Record found", "This Blog Post doesn't exist.");
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			response.put("error", "Something has happened finding the Blog Post. Please try again later.");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
		}
			
		response.put("success", blogPost);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK); 
	}
	
	@DeleteMapping("/posts")
	public ResponseEntity<?> deleteAll() {
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			iBlogPostService.deleteAll();
		}catch(Exception e) {
			response.put("error", "Something has happened deleting all the Blog Posts. Please try again later.");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
		}
			
		response.put("success", "The blog posts have been deleted");
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK); 
	}
	
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<?> deleteById(@PathVariable String id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			iBlogPostService.deleteById((Long.parseLong(id)));
		}catch(Exception e) {
			response.put("error", "Something has happened deleting the Blog Post. Please try again later.");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
		}
			
		response.put("success", new String("The blog post has been deleted."));
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK); 
	}
	
	@PutMapping("/posts/{id}")
	public ResponseEntity<?> update(@RequestBody BlogPostTO blogPostTO, @PathVariable String id) {
		Map<String, Object> response = new HashMap<>();
		BlogPost blogPost = new BlogPost();
		
		try {
			
			blogPost = iBlogPostService.findById( Long.parseLong(id));
			
			if(blogPost == null) {
				response.put("No Record found", "This Blog Post doesn't exist.");
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
			}
			
			blogPost = iBlogPostService.update(blogPostTO, Long.parseLong(id));

		}catch(Exception e) {
			response.put("error", "Something has happened updating the Blog Post. Please try again later.");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
		}
			
		response.put("success", blogPost);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK); 
	}
}
