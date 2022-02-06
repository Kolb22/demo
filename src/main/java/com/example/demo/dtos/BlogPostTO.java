package com.example.demo.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class BlogPostTO {

	private String title;
	private String text;
	private Date timestamp;
	private CategoryTO categoryTO;
	
}
