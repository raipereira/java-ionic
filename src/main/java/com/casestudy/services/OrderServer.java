package com.casestudy.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casestudy.model.Client;
import com.casestudy.model.Ordeer;
import com.casestudy.model.OrderItem;
import com.casestudy.model.PaymentSlip;
import com.casestudy.model.enums.StatusPayment;
import com.casestudy.repositories.ItemRepository;
import com.casestudy.repositories.OrderRepository;
import com.casestudy.repositories.PaymentRepository;
import com.casestudy.services.exceptions.ObjectNotFoundExeption;

@Service
public class OrderServer {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private PaymentRepository pr;
	
	@Autowired
	private ItemRepository ir;
	
	@Autowired
	ProductServer ps;
	
	@Autowired
	SlipServie slipService;
	
	
	public Ordeer findOne(Integer id) {
		Optional<Ordeer> cp = repository.findById(id);
		return cp.orElseThrow(() -> new ObjectNotFoundExeption(
				"Object it's not found id." + id + " Type " + Client.class.getName()));
	}


	@Transactional
	public  Ordeer insert(Ordeer obj) {
		obj.setId(null);
		obj.setDate(LocalDateTime.now());
		obj.getPayment().setStatusPay(StatusPayment.PENDING);
		obj.getPayment().setOrder(obj);
		if(obj.getPayment() instanceof PaymentSlip) {
			PaymentSlip pay = (PaymentSlip) obj.getPayment();
			pay.setDueDate(obj.getDate().plusDays(7));
		}
		
		repository.save(obj);
		pr.save(obj.getPayment());
		
		for(OrderItem item : obj.getItens()) {
			item.setDescount(0.0);
			item.setPrice(ps.find(item.getProduct().getId()).getPrice());
			item.setOrder(obj);
		}
		
		ir.saveAll(obj.getItens());
		
		
		return obj;
	}

}
