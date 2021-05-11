package com.casestudy.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casestudy.model.Address;
import com.casestudy.model.City;
import com.casestudy.model.Client;
import com.casestudy.model.enums.TipeBusiness;
import com.casestudy.repositories.AddressRepository;
import com.casestudy.repositories.ClientRepository;
import com.casestudy.resouces.dto.ClientDTO;
import com.casestudy.resouces.dto.NewClientDTO;
import com.casestudy.services.exceptions.DataIntegrityException;
import com.casestudy.services.exceptions.ObjectNotFoundExeption;

@Service
public class ClientServer {
	
	@Autowired
	private ClientRepository cr;
	
	@Autowired
	private AddressRepository ar;
	
	
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

	
	@Transactional
	public Client insert(Client obj) {
		obj.setId(null);
		Client cli = cr.save(obj);
		ar.saveAll(cli.getAddresses());
		return cli;
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
	
	public Client fromDto(NewClientDTO objDto) {
		
		Client cli = new Client(null, objDto.getName(), objDto.getEmail(), objDto.getSsnOrItin(), TipeBusiness.convertToEnum(objDto.getTipe()));
		City city = new City(objDto.getCityId(), null, null);
		Address adds = new Address(null, objDto.getStreet(), objDto.getNumber(), objDto.getComplement(), objDto.getZip(), cli, city);
		cli.getAddresses().add(adds);
		cli.getPhonenumbers().addAll(Arrays.asList(objDto.getPhone1(), objDto.getPhone2(), objDto.getPhone3()));
		
		return cli;
		
	}
	
	private void clientUpdate(Client obj, Client objDto) {
		obj.setName(objDto.getName());
		obj.setEmail(objDto.getEmail());
	}

}
