package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Person;
import com.main.repository.PersonRepo;

@Service
public class PersonServiceImp implements IPersonService{

	@Autowired
	PersonRepo prepo;
	@Override
	public String registerPerson(Person person) {
		System.out.println("The Person Data is =>> "+person);
		Person pers=prepo.save(person);
		System.out.println(pers);
		return pers.getPId()+": Id Person is Registered";
	}

}
