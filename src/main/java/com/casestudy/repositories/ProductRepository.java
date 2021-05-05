package com.casestudy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
