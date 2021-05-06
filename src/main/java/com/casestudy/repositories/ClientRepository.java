package com.casestudy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
