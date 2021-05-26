package com.casestudy.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import com.casestudy.model.enums.StatusPayment;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("paymentWithSlip")
public class PaymentSlip extends Payment{
	
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDateTime dueDate;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDateTime datePyment;
	
	public PaymentSlip() {
	}

	public PaymentSlip(Integer id, StatusPayment statusPay, Ordeer order, LocalDateTime ld, LocalDateTime datePyment) {
		super(id, statusPay, order);
		this.dueDate = ld;
		this.datePyment = datePyment;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDateTime getDatePyment() {
		return datePyment;
	}

	public void setDatePyment(LocalDateTime datePyment) {
		this.datePyment = datePyment;
	}
	
	
	
	

}
