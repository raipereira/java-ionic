package com.casestudy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.casestudy.model.Client;
import com.casestudy.repositories.ClientRepository;
import com.casestudy.resouces.dto.ClientDTO;
import com.casestudy.services.exceptions.DataIntegrityException;
import com.casestudy.services.exceptions.ObjectNotFoundExeption;

@Service
public class ClientServer {
	
	@Autowired
	private ClientRepository cr;
	
	
	public List<Client> findAll() {
		return cr.findAll();
	}
	
	public Client find(Integer id) {
		Optional<Client> cp = cr.findById(id);
		return cp.orElseThrow(() -> new ObjectNotFoundExeption(
				"Object it's not found id." + id + " Type " + Client.class.getName()));
	}
	
	
	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return cr.findAll(pageRequest);
	}

	

	public Client insert(Client obj) {
		obj.setId(null);
		return cr.save(obj);
	}
	

	public Client update(Client objDto) {
		Client obj = find(objDto.getId());
		clientUpdate(obj, objDto);
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


	public Client fromDto(ClientDTO objDto) {
		return new Client(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null);
	}
	
	private void clientUpdate(Client obj, Client objDto) {
		obj.setName(objDto.getName());
		obj.setEmail(objDto.getEmail());
	}

}
