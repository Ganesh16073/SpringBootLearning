package com.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.main.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
