package com.main.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		boolean exit=true;
		while(exit)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Choice");
			System.out.println("1: Add New Person");
			System.out.println("2: Add Group of Person");
			System.out.println("13: Exit");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1:
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
					break;
					
				case 2:
					try
					{
						List<Person> per=new ArrayList<>(List.of(new Person("Ajay","Chennai",120000d),new Person("Pratik","Banglore",80000d)));
						String msg=personService.registerPersonGroup(per);
						System.out.println(msg);
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 13:
					System.out.println();
					System.out.println("--------------- Exited ---------------");
					System.out.println();
					sc.close();
					exit=false;
					break;
					
					
				default:
					System.out.println();
					System.out.println("----------- Invalid Choice -------------");
					System.out.println();
			}
		}
		
		
		
	}

}
