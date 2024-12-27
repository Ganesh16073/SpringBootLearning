package com.main.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Customer;
import com.main.repository.CustomerRepository;

@Service("customerManagement")
public class CustomerManagementService implements ICustomerManagementService{

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public String registerCustomer(Customer cust) {
		System.out.println("Cust object Data is "+cust);
		Customer c=customerRepository.save(cust);
		return "The Customer obj is Saved (Record inserted) having the id value : "+c.getId();
	}


	@Override
	public String registerCustomerGroup(Iterable<Customer> list) {
		if(list!=null)
		{
			Iterable<Customer> cust=customerRepository.saveAll(list);
			int size=((Collection)cust).size();
			List<Integer> customer=new ArrayList<Integer>();
			cust.forEach(c->customer.add(c.getId()));
			return size+" no of Customer are Register having Id valuse are "+customer.toString();
			
		}
		else
		{
			throw new IllegalArgumentException("Invalid Inputes");
		}
	}


	@Override
	public Boolean isCustomerAvailable(Integer Id) {
		
		return customerRepository.existsById(Id); // check Available or not
	}


	@Override
	public long getCustomerCounnt() {
		long count=customerRepository.count();
		return count;
	}


	@Override
	public Iterable<Customer> getAllCustomer() {
		Iterable<Customer> it=customerRepository.findAll();
		return it;
	}


	@Override
	public Iterable<Customer> getCustomerByIds(Iterable<Integer> ids) {
		Iterable<Customer> li=customerRepository.findAllById(ids);
		return li;
	}


	@Override
	public Optional<Customer> getCustomerById(int id) {
		Optional<Customer> cus=customerRepository.findById(id);
		return cus;
	}


	@Override
	public Customer fetchCustomerById(Integer id) {
		return customerRepository.findById(id).orElse(new Customer(00,"XXX","YYY",0));
	}


	@Override
	public String adjustCustomerBillAmount(int id, double discountPercentage) {
		Optional<Customer> opt=customerRepository.findById(id);
		if(opt.isPresent())
		{
			 Customer cus=opt.get();
			 double discount=cus.getBillAmt()*(discountPercentage/100);
			 cus.setBillAmt(cus.getBillAmt()-discount); 
			 customerRepository.save(cus);
			 return id+" Customer details Updated";
		}
		else
		{
			return id+" Customer details NOt Found";
		}
		
	}

	


}
