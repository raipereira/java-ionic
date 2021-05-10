package com.casestudy.resouces.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.casestudy.model.Category;

public class CategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "The field must not be empty")
	@Length(min = 5, max = 50, message = "length must be between 5 and 50")
	private String name;
	
	public CategoryDTO() {
		
	}
	
	public CategoryDTO(Category obj) {
		id = obj.getId();
		name = obj.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
