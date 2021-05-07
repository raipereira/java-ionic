package com.casestudy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.OrderItem;

@Repository
public interface ItemRepository extends JpaRepository<OrderItem, Integer> {

}
