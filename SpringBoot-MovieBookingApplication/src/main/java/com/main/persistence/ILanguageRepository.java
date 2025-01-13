package com.main.persistence;

import org.springframework.data.repository.CrudRepository;

import com.main.model.Language;

public interface ILanguageRepository extends CrudRepository<Language, Integer>{

}
