package com.casestudy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
