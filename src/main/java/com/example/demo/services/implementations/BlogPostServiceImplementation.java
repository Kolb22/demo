package com.example.demo.services.implementations;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IBlogPostDao;
import com.example.demo.dtos.BlogPostTO;
import com.example.demo.models.BlogPost;
import com.example.demo.models.Category;
import com.example.demo.services.IBlogPostService;

@Service
public class BlogPostServiceImplementation implements IBlogPostService{

	@Autowired
	IBlogPostDao blogPostDao;
	
	@Override
	public BlogPost create(BlogPostTO blogPostTO) {
		
		BlogPost blogPost = new BlogPost();
		Category category = new Category();
		
		blogPost.setText(blogPostTO.getText());
		blogPost.setTitle(blogPostTO.getTitle());
		blogPost.setTimestamp(new Date());
		
		category.setId(blogPostTO.getCategoryTO().getId());
		blogPost.setCategory(category);
		
		return blogPostDao.save(blogPost);
	}

	@Override
	public List<BlogPost> findAll() {
		
		return (List<BlogPost>) blogPostDao.findAll();
	}

	@Override
	public BlogPost findById(Long id) {
		
		return blogPostDao.findById(id).orElse(null);
	}

	@Override
	public void deleteAll() {
		blogPostDao.deleteAll();
	}

	@Override
	public void deleteById(Long id) {
		blogPostDao.deleteById(id);
		
	}

	@Override
	public BlogPost update(BlogPostTO blogPostTO, Long id) {
		
		BlogPost blogPost = new BlogPost();
		Category category = new Category();
		
		blogPost.setId(id);
		blogPost.setText(blogPostTO.getText());
		blogPost.setTitle(blogPostTO.getTitle());
		blogPost.setTimestamp(new Date());
		
		category.setId(blogPostTO.getCategoryTO().getId());
		blogPost.setCategory(category);
		
		return blogPostDao.save(blogPost);
	}

}
