package com.main.persistence;

import org.springframework.data.repository.CrudRepository;

import com.main.model.Cinema;

public interface ICinemaRepository extends CrudRepository<Cinema, Integer>{

}
