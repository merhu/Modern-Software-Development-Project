package com.bah.repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.domain.Customer;

public interface CustomerRepo extends CrudRepository <Customer, Long> {
	public Customer findByName(String name);
}