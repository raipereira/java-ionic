package com.casestudy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.casestudy.model.Category;
import com.casestudy.model.Product;
import com.casestudy.repositories.CategoryRepository;
import com.casestudy.repositories.ProductRepository;
import com.casestudy.services.exceptions.ObjectNotFoundExeption;

@Service
public class ProductServer {
	
	@Autowired
	private ProductRepository pr;
	@Autowired
	private CategoryRepository cr;
	
	
	public List<Product> findAll() {
		return pr.findAll();
	}
	
	
	
	public Product find(Integer id) {
		Optional<Product> cp = pr.findById(id);
		return cp.orElseThrow(() -> new ObjectNotFoundExeption(
				"Object it's not found id." + id + " Type " + Product.class.getName()));
	}
	
	
	public Page<Product> search(String name, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Category> categories = cr.findAllById(ids);
		return pr.findDistinctByNameContainingAndCategoriesIn(name, categories, pageRequest);
	}

	


}
