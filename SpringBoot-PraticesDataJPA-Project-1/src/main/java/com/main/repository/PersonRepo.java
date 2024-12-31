package com.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.main.entity.Person;

public interface PersonRepo extends CrudRepository<Person,Integer>{

}
