package com.main.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Movie;
import com.main.persistence.IMovieRepository;

@Service
public class MovieServiceImp implements IMovieService{
	@Autowired
	IMovieRepository mrepo;

	@Override
	public String addMovie(Movie movie) throws Exception {
		try
		{
			Movie m=mrepo.save(movie);
			return m.getMovieId()+" :: id Movie added";
			
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean isMovieAvailableById(Integer id) throws Exception {
		try
		{
			Optional<Movie> m=mrepo.findById(id);
			if(m.isPresent())
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public Long getMovieCount() throws Exception {
		try
		{
			return mrepo.count();
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Iterable<Movie> getAllMovies() throws Exception {
		try
		{
			return mrepo.findAll();
			
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Iterable<Movie> getMovieByIds(Iterable<Integer> ids) throws Exception {
		try
		{
			Iterable<Movie> m=mrepo.findAllById(ids);
			if(((Collection)m).size()==((Collection)ids).size())
			{
				return m;
			}
			else
			{
				System.out.println("All Movies With ids is not found");
				return null;
			}
			
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Optional<Movie> getMovieById(Integer id) throws Exception {
		try
		{
			Optional<Movie> m=mrepo.findById(id);
			if(m.isPresent())
			{
				return m;
			}
			else
			{
				System.out.println("Movie is not found");
				return Optional.empty();
			}
			
		}catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public Movie getMovieByIdOrGetDefaultMovie(Integer id) throws Exception {
		try
		{
			Optional<Movie> m=mrepo.findById(id);
			if(m.isPresent())
			{
				return m.get();
			}
			else
			{
				return new Movie();
			}
			
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public String updateMovieById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeMovieById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
