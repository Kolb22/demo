package com.example.demo.services;

import java.util.List;

import com.example.demo.dtos.BlogPostTO;
import com.example.demo.models.BlogPost;

public interface IBlogPostService {

	public BlogPost create(BlogPostTO blogPostTO);
	public List<BlogPost> findAll();
	public BlogPost findById(Long id);
	public void deleteAll();
	public void deleteById(Long id);
	public BlogPost update(BlogPostTO blogPostTO, Long id);
}
