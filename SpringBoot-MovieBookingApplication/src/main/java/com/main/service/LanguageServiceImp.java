package com.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Language;
import com.main.persistence.ILanguageRepository;

@Service
public class LanguageServiceImp implements ILanguageService{
	
	@Autowired
	private ILanguageRepository langRepo;

	@Override
	public String addLanguage(Language language)throws Exception {
		try
		{
			Language lan=langRepo.save(language);
			return "The Language : "+lan.getLanguageName()+" added and id is "+lan.getLanguageId();
			
		}catch (Exception e) {
			throw e;
		}
	}
	@Override
	public boolean isLanguageAvaliableById(Integer id) throws Exception {
		try
		{
			Optional<Language> lang=langRepo.findById(id);
			if(lang.isPresent())
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
	public Long getLanguageCount() throws Exception {
		try
		{
			return langRepo.count();
			
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Iterable<Language> getAllLanguage() throws Exception {
		try
		{
			return langRepo.findAll();
		}catch (Exception e) {
			throw e;
		}
		
	}
	@Override
	public Iterable<Language> getAllLanguageByIds(Iterable<Integer> ids) throws Exception {
		try
		{
			return langRepo.findAllById(ids);
		}catch (Exception e) {
			throw e;
		}
		
	}
	@Override
	public Optional<Language> getLanguageById(Integer id) throws Exception {
		try
		{
			return langRepo.findById(id);
		}catch (Exception e) {
			throw e;
		}
		
	}
	@Override
	public Language getLanguageByIdOrGetDefaultLanguage(Integer id) throws Exception {
		try
		{
			Optional<Language> lan=langRepo.findById(id);
			if(lan.isPresent())
			{
				return lan.get();
			}
		}catch (Exception e) {
			throw e;
		}
		return new Language(0,"Default");
	}
	@Override
	public String updateLanguageNameById(Integer id, String updateLangName) throws Exception {
		try
		{
			Optional<Language> lang=langRepo.findById(id);
			if(lang.isPresent())
			{
				lang.get().setLanguageName(updateLangName);
				langRepo.save(lang.get());
				return "The Language is Updated";
				
			}
			else
			{
				return "The Language id : "+id+" is Not Found";
			}
			
		}catch (Exception e) {
			throw e;
		}
	}
	@Override
	public String removeLanguageById(Integer id) throws Exception {
		try
		{
			Optional<Language> lang=langRepo.findById(id);
			if(lang.isPresent())
			{
				langRepo.deleteById(id);
				return id+" : id Language is Deleted";
			}
			else
			{
				return "The Language is not found with id "+id;
			}
		}catch (Exception e) {
			throw e;
		}
	}

}
