package com.casestudy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.model.Client;
import com.casestudy.repositories.ClientRepository;
import com.casestudy.services.exceptions.ObjectNotFoundExeption;

@Service
public class ClientServer {
	
	@Autowired
	private ClientRepository cr;
	
	
	public Client findOne(Integer id) {
		
		Optional<Client> cp = cr.findById(id);
		
		return cp.orElseThrow(() -> new ObjectNotFoundExeption(
				"Object it's not found id." + id + " Type " + Client.class.getName()));
	}

}
