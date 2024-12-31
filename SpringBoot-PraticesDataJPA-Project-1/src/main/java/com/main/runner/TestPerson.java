package com.main.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.main.entity.Person;
import com.main.service.PersonServiceImp;

@Component
public class TestPerson implements CommandLineRunner{

	@Autowired
	PersonServiceImp personService;
	
	@Override
	public void run(String... args) throws Exception {
		try
		{
			Person per=new Person();
			per.setPName("Akhi");
			per.setPAddress("Pune");
			per.setPSalary(30000d);
			String resultMessage=personService.registerPerson(per);
			System.out.println(resultMessage);
			if(resultMessage==null)
			{
				System.out.println("Person Not Registered");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
