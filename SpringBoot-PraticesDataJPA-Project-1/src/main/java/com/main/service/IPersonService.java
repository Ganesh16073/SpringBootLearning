package com.main.service;

import java.util.List;
import java.util.Optional;

import com.main.entity.Person;

public interface IPersonService {
	
	public String registerPerson(Person person);
	public String registerPersonGroup(Iterable<Person> list);
	public Boolean isPersonAvailable(Integer id);
	public long getPersonCount();
	public Iterable<Person> getAllPerson();
	public Iterable<Person> getPersonsById(Iterable<Integer> ids);
	public Optional<Person> getPersonById(int id);
	public Person getPersonByIdDefault(int id);
	public String updatePersonSalaryById(int id, double newSalary);
	public String registerOrUpdatePerson(Person person);
	public String removePersonById(int id);
	public String removePerson(Person person);
//	public String deleteAllPersonById(List<Integer> id);
//	public String deleteAllPersons();

}
