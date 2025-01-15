package com.main.persistence;

import org.springframework.data.repository.CrudRepository;

import com.main.model.Genres;

public interface IGenresRepository extends CrudRepository<Genres, Integer>{

}
