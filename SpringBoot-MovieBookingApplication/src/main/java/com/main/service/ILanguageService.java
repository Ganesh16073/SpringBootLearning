package com.main.service;

import com.main.model.Language;

public interface ILanguageService {
	public String addLanguage(Language language) throws Exception;
	public boolean isLanguageAvaliableById(Integer id) throws Exception;
	public Long getLanguageCount()throws Exception;
	

}
