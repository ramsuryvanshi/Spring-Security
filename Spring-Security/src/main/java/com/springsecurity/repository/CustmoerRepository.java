package com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.entities.Customer;

public interface CustmoerRepository extends JpaRepository<Customer,Integer> {
  
	
	public Customer findByEmail(String email);
}
