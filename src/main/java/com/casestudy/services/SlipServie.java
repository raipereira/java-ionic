package com.casestudy.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.casestudy.model.PaymentSlip;

@Service
public class SlipServie {

	public void calculeteDueDate(PaymentSlip pay, LocalDateTime date) {
		pay.setDueDate(date.plusDays(7));
		
		
	}
	
	

}
