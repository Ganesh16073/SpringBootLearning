package com.main.service;

import java.util.Arrays;

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
	@Override
	public String registerPersonGroup(Iterable<Person> list) {
		if(list!=null)
		{
			try
			{
				System.out.println();
				System.out.println("-------------- The Given Person Data is ------------");
				list.forEach(System.out::println);
				System.out.println("=============================================");
				System.out.println();
				Iterable<Person> l=prepo.saveAll(list);
				return "The Registered Persons are "+l.toString();
				
			}catch (Exception e) {
				e.printStackTrace();
				return "Some Problem is there............";
			}			
		}
		else
		{
			System.out.println();
			return "The Person List is Empty";
		}
	}

}
