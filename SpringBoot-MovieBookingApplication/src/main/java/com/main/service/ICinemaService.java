package com.main.service;

import com.main.model.Cinema;

public interface ICinemaService {
	public String addCinema(Cinema cinema)throws Exception;
	public boolean isCinemaAvaliableById(Integer id)throws Exception;
	public Long getCinemaCount()throws Exception;
	public Iterable<Cinema> getAllCinema()throws Exception;

}
