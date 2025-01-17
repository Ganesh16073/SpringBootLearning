package com.main.persistence;

import org.springframework.data.repository.CrudRepository;

import com.main.model.Movie;

public interface IMovieRepository extends CrudRepository<Movie, Integer>{

}
