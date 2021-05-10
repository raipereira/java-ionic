package com.casestudy.resouces;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.casestudy.model.Category;
import com.casestudy.resouces.dto.CategoryDTO;
import com.casestudy.services.CategoryServer;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResouce {
	
	@Autowired
	private CategoryServer service;
	
	
	@GetMapping()
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<Category> list = service.findAll();
		List<CategoryDTO> listDto = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<CategoryDTO>> findPanation(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue = "name")String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC") String direction) {
		Page<Category> pages = service.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoryDTO> pagesDto = pages.map(obj -> new CategoryDTO(obj));
		return ResponseEntity.ok().body(pagesDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> find(@PathVariable Integer id) {
		Category obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody CategoryDTO objDto){
		Category obj = service.fromDto(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				  .path("{/}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Category obj, @PathVariable Integer id){
		obj.setId(id);
		service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
