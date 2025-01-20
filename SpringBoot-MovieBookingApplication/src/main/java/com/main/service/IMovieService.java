package com.main.service;

import java.util.Optional;

import com.main.model.Movie;

public interface IMovieService {
	public String addMovie(Movie movie) throws Exception;
	public boolean isMovieAvailableById(Integer id)throws Exception;
	public Long getMovieCount()throws Exception;
	public Iterable<Movie> getAllMovies()throws Exception;
	public Iterable<Movie> getMovieByIds(Iterable<Integer> ids)throws Exception;
	public Optional<Movie> getMovieById(Integer id)throws Exception;
	public Movie getMovieByIdOrGetDefaultMovie(Integer id)throws Exception;
	public String updateMovieNameById(Integer id,String name)throws Exception;
	public String removeMovieById(Integer id)throws Exception;

}
