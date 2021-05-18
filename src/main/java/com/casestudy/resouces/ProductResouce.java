package com.casestudy.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.Product;
import com.casestudy.resouces.dto.ProductDTO;
import com.casestudy.resouces.uties.URL;
import com.casestudy.services.ProductServer;

@RestController
@RequestMapping(value = "/products")
public class ProductResouce {
	
	@Autowired
	private ProductServer service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		List<Product> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	
	@GetMapping()
	public ResponseEntity<Page<ProductDTO>> findPanation(
			@RequestParam(value="name", defaultValue = "") String name, 
			@RequestParam(value="categories", defaultValue = "") String categories,
			@RequestParam(value="page", defaultValue = "0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue = "name")String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC") String direction) {
		List<Integer> ids = URL.decodeIntList(categories);
		String nameDecod = URL.decodeParam(name);
		Page<Product> pages = service.search(nameDecod, ids,	 page, linesPerPage, orderBy, direction);
		Page<ProductDTO> pagesDto = pages.map(obj -> new ProductDTO(obj));
		return ResponseEntity.ok().body(pagesDto);
	}

}
