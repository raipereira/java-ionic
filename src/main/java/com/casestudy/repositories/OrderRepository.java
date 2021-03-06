package com.casestudy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.Ordeer;

@Repository
public interface OrderRepository extends JpaRepository<Ordeer, Integer> {

}
