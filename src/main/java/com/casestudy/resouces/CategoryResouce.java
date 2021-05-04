package com.casestudy.resouces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResouce {
	
	@GetMapping
	public String list() {
		return "Test end-point";
	}

}
