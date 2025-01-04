package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	public List<Customer> findByNameEquals(String name);
	public List<Customer> findByNameIs(String name);
}
