package com.main.service;

import java.util.List;
import java.util.Optional;

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
	@Override
	public Boolean isPersonAvailable(Integer id) {
		try
		{
			return prepo.existsById(id);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public long getPersonCount() {
		try
		{
			long count=prepo.count();
			return count;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	@Override
	public Iterable<Person> getAllPerson() {
		try
		{
			Iterable<Person> list=prepo.findAll();
			return list;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Iterable<Person> getPersonsById(Iterable<Integer> ids) {
			
		try
		{
			Iterable<Person> list=prepo.findAllById(ids);
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	@Override
	public Optional<Person> getPersonById(int id) {
		try
		{
			Optional<Person> person=prepo.findById(id);
			return person;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	@Override
	public Person getPersonByIdDefault(int id) {
		try
		{
			Person per=prepo.findById(id).orElse(new Person(0,"XYZ","ABC",0d));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String updatePersonSalaryById(int id, double newSalary) {
		
		Optional<Person> per=prepo.findById(id);
		if(per.isPresent())
		{
			Person p=per.get();
			p.setPSalary(newSalary);
			prepo.save(p);
			return p.getPId()+"Person Salary Is Updated";
		}
		else
		{
			return "Person data is Not found in database List with id"+id;
		}
		
	}
	@Override
	public String registerOrUpdatePerson(Person person) {
		Optional<Person> per=prepo.findById(person.getPId());
		if(per.isPresent())
		{
			prepo.save(person);
			return per.get().getPId()+" : ids Person data is updated";
		}
		return person.getPId()+": ids Person Not found";
	}
	@Override
	public String removePersonById(int id) {
		Optional<Person> per=prepo.findById(id);
		if(per.isPresent())
		{
			prepo.deleteById(id);
			return id+" : id person is Deleted";
		}
		return id+" : id Person was not Found";
	}
	@Override
	public String removePerson(Person person) {
		Optional<Person> per=prepo.findById(person.getPId());
		if(per.isPresent())
		{
			prepo.delete(person);
			return person.getPId()+" : id person is Deleted";
		}
		return person.getPId()+" : id Person was not Found";
	}
	@Override
	public String deleteAllPersonById(List<Integer> id) {
		
		List<Person> pre=(List<Person>) prepo.findAllById(id);
		if(pre.size()==id.size())
		{
			prepo.deleteAllById(id);
			return "Person are deleted by ids : "+id.toString();
		}
		return "Person are not deleted by ids : "+id.toString();
	}
	@Override
	public String deleteAllPersons() {
		
		prepo.deleteAll();
		return "All Person Are Deleted";
	}
	
	

}
