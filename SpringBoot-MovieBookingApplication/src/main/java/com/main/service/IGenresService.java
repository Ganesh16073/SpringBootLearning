package com.main.service;

import java.util.Optional;

import com.main.model.Genres;

public interface IGenresService {
	public String addGenres(Genres genres)throws Exception;
	public boolean isGenreAvailableById(Integer Id)throws Exception;
	public Long getCountOfGenres()throws Exception;
	public Iterable<Genres> getAllGenres()throws Exception;
	public Iterable<Genres> getAllGenresById(Iterable<Integer> ids)throws Exception;
	public Optional<Genres> getLanguageById(Integer id)throws Exception;
	public String updateGenresByID(Integer id,String name)throws Exception;
	public String removeGenresById(Integer id)throws Exception;
}
