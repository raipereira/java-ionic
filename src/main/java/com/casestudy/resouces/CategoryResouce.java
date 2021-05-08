package com.casestudy.resouces;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.casestudy.model.Category;
import com.casestudy.services.CategoryServer;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResouce {
	
	@Autowired
	private CategoryServer cs;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> find(@PathVariable Integer id) {
		Category obj = cs.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Category obj){
		obj = cs.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				  .path("{/}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Category obj, @PathVariable Integer id ){
		obj.setId(id);
		cs.update(obj);
		return ResponseEntity.noContent().build();
		
	}

}
