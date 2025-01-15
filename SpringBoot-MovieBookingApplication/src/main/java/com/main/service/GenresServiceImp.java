package com.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.main.model.Genres;
import com.main.persistence.IGenresRepository;

public class GenresServiceImp implements IGenresService{
	@Autowired
	IGenresRepository grepo;

	@Override
	public String addGenres(Genres genres) throws Exception {
		try
		{
			Genres o=grepo.save(genres);
			return o.getGenresId()+" :id new Genres is added";
		}catch (Exception e) {
			throw e;
		}
	
	}

	@Override
	public boolean isGenreAvailableById(Integer Id) throws Exception {
		try
		{
			Optional<Genres> o=grepo.findById(Id);
			if(o.isPresent()) return true;
			else return false;
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Long getCountOfGenres() throws Exception {
		try
		{
			return grepo.count();
		}catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public Iterable<Genres> getAllGenres() throws Exception {
		try
		{
			return grepo.findAll();
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Iterable<Genres> getAllGenresById(Iterable<Integer> ids) throws Exception {
		try
		{
			return grepo.findAllById(ids);
			
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Optional<Genres> getLanguageById(Integer id) throws Exception {
		try
		{
			Optional<Genres> o=grepo.findById(id);
			if(o.isPresent())
			{
				return o;
			}
			else
			{
				return Optional.empty();
			}
			
		}catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public String updateGenresByID(Integer id, String name) throws Exception {
		try
		{
			Optional<Genres> o=grepo.findById(id);
			if(o.isPresent())
			{
				o.get().setGenresName(name);
				Genres s=grepo.save(o.get());
				return s.getGenresId()+": id Genres os Updated";
			}
			else
			{
				return id+": id is Not found";
			}
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public String removeGenresById(Integer id) throws Exception {
		try
		{
			Optional<Genres> o=grepo.findById(id);
			if(o.isPresent())
			{
				grepo.deleteById(id);
				return id+": id Genren is Deleted";
			}
			else
			{
				return id+": id is Not found";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	

}
