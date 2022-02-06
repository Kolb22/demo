package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.BlogPost;

public interface IBlogPostDao extends CrudRepository<BlogPost, Long>{

}
