package com.main.service;

import java.time.LocalDate;
import java.time.LocalTime;
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
	public String updateMovieNameById(Integer id, String name) throws Exception {
		try
		{
			Optional<Movie> m=mrepo.findById(id);
			if(m.isPresent())
			{
				m.get().setTitle(name);
				Movie mo=mrepo.save(m.get());
				return mo.getMovieId()+"Movie Title is updated";
				
			}else {
				return id+"Movie Title is not found";
			}	
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public String removeMovieById(Integer id) throws Exception {
		try
		{
			Optional<Movie> m=mrepo.findById(id);
			if(m.isPresent())
			{
				mrepo.deleteById(id);
				return id+":: id Movie is Deleted";
				
			}else {
				return id+":: id Movie is Not found";
			}	
		}catch (Exception e) {
			throw e;
		}
	}

	public String updateMovieGenreById(Integer id,String Genren)throws Exception
	{
		try
		{
			Optional<Movie> m=mrepo.findById(id);
			if(m.isPresent())
			{
				m.get().setGenre(Genren);
				Movie mo=mrepo.save(m.get());
				return mo.getMovieId()+"Movie Genres is updated";
				
			}else {
				return id+"Movie Genres is not found";
			}	
		}catch (Exception e) {
			throw e;
		}
		
	}

	public String updateMovieDuriationById(Integer id,LocalTime time)throws Exception
	{
		try
		{
			Optional<Movie> m=mrepo.findById(id);
			if(m.isPresent())
			{
				m.get().setDuration(time);
				Movie mo=mrepo.save(m.get());
				return mo.getMovieId()+"Movie Duration is updated";
				
			}else {
				return "Movie with ID " + id + " is not found";
			}	
		}catch (Exception e) {
			throw e;
		}
	}
	public String updateMovieDateById(Integer id,LocalDate data)throws Exception
	{
		try
		{
			Optional<Movie> m=mrepo.findById(id);
			if(m.isPresent())
			{
				m.get().setReleaseDate(data);;
				Movie mo=mrepo.save(m.get());
				return mo.getMovieId()+"Movie Date is updated";
				
			}else {
				return "Movie with ID " + id + " is not found";
			}	
		}catch (Exception e) {
			throw e;
		}
	}
	public String updateMovieDiscriptionById(Integer id,String Discription)throws Exception
	{
		try
		{
			Optional<Movie> m=mrepo.findById(id);
			if(m.isPresent())
			{
				m.get().setDiscription(Discription);
				Movie mo=mrepo.save(m.get());
				return mo.getMovieId()+"Movie Discription is updated";
				
			}else {
				return "Movie with ID " + id + " is not found";
			}	
		}catch (Exception e) {
			throw e;
		}
	}

	public String updateMoviePosternById(Integer id,String path)throws Exception
	{
		try
		{
			Optional<Movie> m=mrepo.findById(id);
			if(m.isPresent())
			{
				m.get().setPoster(path);
				Movie mo=mrepo.save(m.get());
				return mo.getMovieId()+"Movie Path is updated";
				
			}else {
				return "Movie with ID " + id + " is not found";
			}	
		}catch (Exception e) {
			throw e;
		}
	}
}