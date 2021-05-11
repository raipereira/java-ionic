package com.casestudy.resouces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.Ordeer;
import com.casestudy.services.OrderServer;

@RestController
@RequestMapping(value = "/orders")
public class OrderResouce {
	
	@Autowired
	private OrderServer os;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		Ordeer obj = os.findOne(id);
		return ResponseEntity.ok().body(obj);
	}

}
