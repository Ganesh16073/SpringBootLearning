package com.main.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.main.entity.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer>{

}
