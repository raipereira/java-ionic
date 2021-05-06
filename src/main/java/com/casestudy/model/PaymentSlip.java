package com.casestudy.model;

import java.util.Date;

import javax.persistence.Entity;

import com.casestudy.model.enums.StatusPayment;

@Entity
public class PaymentSlip extends Payment{
	
	private Date dueDate;
	private Date datePyment;
	
	public PaymentSlip() {
	}

	public PaymentSlip(Integer id, StatusPayment statusPay, Ordering order, Date duePyment, Date datePyment) {
		super(id, statusPay, order);
		this.dueDate = duePyment;
		this.datePyment = datePyment;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getDatePyment() {
		return datePyment;
	}

	public void setDatePyment(Date datePyment) {
		this.datePyment = datePyment;
	}
	
	
	
	

}
