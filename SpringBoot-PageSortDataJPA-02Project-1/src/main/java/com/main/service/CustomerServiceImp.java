package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.main.entity.Customer;
import com.main.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements ICustomerService{

	@Autowired
	private CustomerRepository cusRepo;
	
	@Override
	public Iterable<Customer> getAllCustomers(boolean ascOrder, String... properties) {
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,properties);
		Iterable<Customer> it=cusRepo.findAll(sort);
		return it; 
	}

	@Override
	public Page<Customer> getCustomerByPageNo(int pageNo, int pageSize) {
		// Prepare Pageable Object
		Pageable pageable=PageRequest.of(pageNo, pageSize);
		//Get Requested Page Details
		Page<Customer> page=cusRepo.findAll(pageable);
		return page;
	}

	@Override
	public Page<Customer> getSortedCustomerByPage(int pageNo, int pageSize, boolean order, String... properties) {
	
	Sort sort=Sort.by(order?Direction.ASC:Direction.DESC,properties);
	Pageable pageable=PageRequest.of(pageNo, pageSize,sort);
	
	
	Page<Customer> page=cusRepo.findAll(pageable);
		
		return page;
	}

	@Override
	public void showCustomersPageByPage(int pageSize) {
		 long count=cusRepo.count();
		 long pageCount=count/pageSize;
		 pageCount=(count%pageSize==0)?pageCount:pageCount++;
		 
		 for(int i=0;i<=pageCount;i++)
		 {
			 Pageable pageable=PageRequest.of(i, pageSize);
			 Page<Customer> page=cusRepo.findAll(pageable);
			 page.forEach(System.out::println);
			 System.out.println("---------"+(page.getNumber()+1)+"/"+page.getTotalPages()+"--------");
		 }
				 
	}

}
