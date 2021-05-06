package com.casestudy.resouces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.Client;
import com.casestudy.services.ClientServer;

@RestController
@RequestMapping(value = "/clients")
public class ClientResouce {
	
	@Autowired
	private ClientServer cs;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		
		Client obj = cs.findOne(id);
		
		return ResponseEntity.ok().body(obj);
	}

}
