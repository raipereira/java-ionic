package com.casestudy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.model.Category;
import com.casestudy.repositories.CategoryRepository;
import com.casestudy.services.exceptions.ObjectNotFoundExeption;

@Service
public class CategoryServer {
	
	@Autowired
	private CategoryRepository cr;
	
	
	public Category findOne(Integer id) {
		
		Optional<Category> cp = cr.findById(id);
		
		return cp.orElseThrow(() -> new ObjectNotFoundExeption(
				"Object it's not found id." + id + " Type " + Category.class.getName()));
	}


	public Category insert(Category obj) {
		obj.setId(null);
		return cr.save(obj);
	}

}
