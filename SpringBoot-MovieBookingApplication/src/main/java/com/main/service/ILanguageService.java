package com.main.service;

import java.util.Optional;

import com.main.model.Language;

public interface ILanguageService {
	public String addLanguage(Language language) throws Exception;
	public boolean isLanguageAvaliableById(Integer id) throws Exception;
	public Long getLanguageCount()throws Exception;
	public Iterable<Language> getAllLanguage() throws Exception;
	public Iterable<Language> getAllLanguageByIds(Iterable<Integer> ids)throws Exception;
	public Optional<Language> getLanguageById(Integer id)throws Exception;
	public Language getLanguageByIdOrGetDefaultLanguage(Integer id)throws Exception;
	public String updateLanguageNameById(Integer id, String updateLangName)throws Exception;
	public String removeLanguageById(Integer id)throws Exception;
	

}
