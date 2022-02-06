package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Category;

public interface ICategoryDao extends CrudRepository<Category, Long>{

}
