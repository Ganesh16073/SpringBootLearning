package com.main.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.main.repository.ICustomerRepository;

@Component
public class TestFinderMethod implements CommandLineRunner{

	@Autowired
	ICustomerRepository repo;
	@Override
	public void run(String... args) throws Exception {
		repo.findByNameEquals("Akhi").forEach(System.out::println);
		System.out.println("==========================");
		repo.findByNameIs("Akhi").forEach(System.out::println);
		System.out.println("==========================");
	}

}
