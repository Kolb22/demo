package com.example.demo.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICategoryDao;
import com.example.demo.models.Category;
import com.example.demo.services.ICategoryServices;

@Service
public class CategoryServiceImplementation implements ICategoryServices {
	
	@Autowired
	ICategoryDao categoryDao;

	@Override
	public List<Category> findAll() {
		
		return (List<Category>) categoryDao.findAll();
	}

	
}
