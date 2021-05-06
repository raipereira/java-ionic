package com.casestudy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
