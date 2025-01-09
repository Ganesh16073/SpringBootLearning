package com.main.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
			System.out.println();
			System.out.println("-------------------------------------------------------------");
			System.out.println("|<<<<<<<<<<<<<<<<<<<<<<<< Enter the Choice>>>>>>>>>>>>>>>>>>>>|");
			System.out.println("|  1: Add New Person                                          |");
			System.out.println("|  2: Add Group of Person                                     |");
			System.out.println("|  3: Check is PersonAvailable By id                          |");
			System.out.println("|  4: get Person Count                                        |");
			System.out.println("|  5: get All Person From database                            |");
			System.out.println("|  6: get multiple Persons By Id                              |");
			System.out.println("|  7: get a Person By Id                                      |");
			System.out.println("|  8: get a Person By Id or get Default Person                |");
			System.out.println("|  9: update Person Salary By Id                              |");
			System.out.println("|  10: register Person Or Update Person if already exist      |");
			System.out.println("|  11: remove a Person By Id                                  |");
			System.out.println("|  12: remove Person by pasing an person all data             |");
			System.out.println("|  13: delete All Person By Ids                               |");
			System.out.println("|  14: delete All the Persons                                 |");
			System.out.println("|  15: Exit                                                   |");
			System.out.println("--------------------------------------------------------------|");
			System.out.println();
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
					
				case 3:
					try
					{
						System.out.println("Enter the Id TO Search the Person is Available or not");
						int id=sc.nextInt();
						boolean b=personService.isPersonAvailable(id);
						if(b)
						{
							System.out.println(id+"=> The id Person Is Presenet in In Database");
						}
						else
						{
							System.out.println(id+"=> The id Person is Not Avaliable in Database");
						}
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 4:
					try
					{
						long count=personService.getPersonCount();
						if(count!=-1)
						{
							System.out.println("The Person count is => "+count);
						}
						else
						{
							System.out.println("There is No Person Avaliable in Database");
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 5:
					try
					{
						Iterable<Person> list=personService.getAllPerson();
						System.out.println("The Person List is =>");
						list.forEach(System.out::println);
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 6:
					try
					{
						System.out.println("Enter the Id to Search Person");
						List<Integer> id=new ArrayList<>();
						boolean enterId=true;
						while(enterId)
						{
							var fid=sc.nextInt();
							id.add(fid);
							System.out.println("Want to add another id to Search enter=>> Y : N");
							char ch=sc.next().charAt(0);
							if(ch=='n' || ch=='N')
							{
								enterId=false;
							}
						}
						
						Iterable<Person> list=personService.getPersonsById(id);
						if(list!=null)
						{
							System.out.println("The Person List Is");
							list.forEach(System.out::println);
						}
						else
						{
							System.out.println("There is no Person in this Ids +"+id.toString());
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 7:
					try
					{
						System.out.println("Enter the Person Id to Find ::");
						int id=sc.nextInt();
						Optional<Person> per=personService.getPersonById(id);
						if(per.isPresent())
						{
							System.out.println("The Person with id "+id+" Details are =>");
							System.out.println(per.get());
						}
						else
						{
							System.out.println("There Is No Person Avaliable in Database with id "+id);
						}
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
				
				case 8:
					try
					{
						System.out.println("Enter the Person Id to Find Person or get Default person Details");
						int id=sc.nextInt();
						Person p=personService.getPersonByIdDefault(id);
						System.out.println("The Person Details Are "+p);
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 9:
					try
					{
						System.out.println("Enter the Person id to update Salary");
						int id=sc.nextInt();
						System.out.println("Enter the New Salary to Update");
						double newSal=sc.nextDouble();
						String resMess=personService.updatePersonSalaryById(id, newSal);
						System.out.println(resMess);
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 10:
					try
					{
						System.out.println("Enter the Person data to Update");
						Person p=new Person();
						p.setPId(sc.nextInt());
						p.setPName(sc.next());
						p.setPAddress(sc.next());
						p.setPSalary(sc.nextDouble());
						String message=personService.registerOrUpdatePerson(p);
						System.out.println(message);
						
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 11:
					try
					{
						System.out.println("Enter the Person id to delete");
						int id =sc.nextInt();
						String mess=personService.removePersonById(id);
						System.out.println(mess);
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 12:
					try
					{
						System.out.println("Enter the Person Person Details delete");
						Person p=new Person();
						p.setPId(sc.nextInt());
						String mesg=personService.removePersonById(choice);
						System.out.println(mesg);
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 13:
					try
					{
						List<Integer> list=new ArrayList<>();
						boolean check=true;
						System.out.println("Enter the ids to delete");
						while(check)
						{
							list.add(sc.nextInt());
							System.out.println("Want to delete more Person with id :: Enter 'Y' Or 'N' ");
							char ch=sc.next().charAt(0);
							if(ch=='n'|| ch=='N')
							{
								check=false;
							}
						}
						String mesg=personService.deleteAllPersonById(list);
						System.out.println(mesg);
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 14:
					try
					{
						System.out.println(personService.deleteAllPersons());
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 15:
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
