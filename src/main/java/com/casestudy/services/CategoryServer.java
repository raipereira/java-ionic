package com.casestudy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.model.Category;
import com.casestudy.repositories.CategoryRepository;

@Service
public class CategoryServer {
	
	@Autowired
	private CategoryRepository cr;
	
	
	public Category findOne(Integer id) {
		
		Optional<Category> cp = cr.findById(id);
		
		return cp.orElse(null);
	}

}
