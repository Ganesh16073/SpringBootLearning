package com.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Cinema;
import com.main.persistence.ICinemaRepository;

@Service
public class CinemaServiceImp implements ICinemaService {

	@Autowired
	ICinemaRepository cinemaRepo;
	
	@Override
	public String addCinema(Cinema cinema) throws Exception {
		
		return cinemaRepo.save(cinema).getCinemaId()+" :: id Cinema is Added";
	}

	@Override
	public boolean isCinemaAvaliableById(Integer id) throws Exception {
		Optional<Cinema> c=cinemaRepo.findById(id);
		if(c.isPresent()) return true;
		return false;
	}

	@Override
	public Long getCinemaCount() throws Exception {
		return cinemaRepo.count();
	}

	@Override
	public Iterable<Cinema> getAllCinema() throws Exception {
		return cinemaRepo.findAll();
	}
	

}
