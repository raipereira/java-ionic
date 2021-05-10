package com.casestudy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.casestudy.model.Category;
import com.casestudy.repositories.CategoryRepository;
import com.casestudy.resouces.dto.CategoryDTO;
import com.casestudy.services.exceptions.DataIntegrityException;
import com.casestudy.services.exceptions.ObjectNotFoundExeption;

@Service
public class CategoryServer {
	
	@Autowired
	private CategoryRepository cr;
	
	
	public List<Category> findAll() {
		return cr.findAll();
	}
	
	
	public Category find(Integer id) {
		Optional<Category> cp = cr.findById(id);
		return cp.orElseThrow(() -> new ObjectNotFoundExeption(
				"Object it's not found id." + id + " Type " + Category.class.getName()));
	}
	
	
	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return cr.findAll(pageRequest);
	}

	

	public Category insert(Category obj) {
		obj.setId(null);
		return cr.save(obj);
	}
	


	public Category update(Category obj) {
		find(obj.getId());
		return cr.save(obj);
	}
	


	public void delete(Integer id) {
		find(id);
		try {
			cr.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
				"I'm sorry! it's not possible to delete the category associated with the Product");
			}
	}


	public Category fromDto(CategoryDTO objDto) {
		return new Category(objDto.getId(), objDto.getName());
	}


}
