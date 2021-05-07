package com.casestudy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.model.Client;
import com.casestudy.model.Ordeer;
import com.casestudy.repositories.OrderRepository;
import com.casestudy.services.exceptions.ObjectNotFoundExeption;

@Service
public class OrderServer {
	
	@Autowired
	private OrderRepository or;
	
	
	public Ordeer findOne(Integer id) {
		
		Optional<Ordeer> cp = or.findById(id);
		
		return cp.orElseThrow(() -> new ObjectNotFoundExeption(
				"Object it's not found id." + id + " Type " + Client.class.getName()));
	}

}
