package com.casestudy.resouces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResouce {
	
	@GetMapping
	public List<Category> list() {
		
		Category c1 = new Category(1, "Informatic");
		Category c2 = new Category(2, "Office equipaments");
		
		List<Category> clist = new ArrayList<>();
		clist.add(c1);
		clist.add(c2);
		
		return clist;
	}

}
