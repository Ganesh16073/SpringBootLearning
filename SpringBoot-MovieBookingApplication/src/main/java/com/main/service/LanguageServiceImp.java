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
	public String addLanguage(Language language) throws Exception {
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

}
