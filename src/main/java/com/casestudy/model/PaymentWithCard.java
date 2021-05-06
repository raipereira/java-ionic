package com.casestudy.model;

import javax.persistence.Entity;

import com.casestudy.model.enums.StatusPayment;

@Entity
public class PaymentWithCard extends Payment {
	
	private Integer numberInstallments;

	public PaymentWithCard() {
		
	}

	public PaymentWithCard(Integer id, StatusPayment statusPay, Ordering order, Integer numberInstallments) {
		super(id, statusPay,order);
		this.numberInstallments = numberInstallments;
		
	}

	public Integer getNumberInstallments() {
		return numberInstallments;
	}

	public void setNumberInstallments(Integer numberInstallments) {
		this.numberInstallments = numberInstallments;
	}
	
	
}
