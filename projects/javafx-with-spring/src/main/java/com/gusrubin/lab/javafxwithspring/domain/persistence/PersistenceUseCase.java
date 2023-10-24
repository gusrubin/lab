package com.gusrubin.lab.javafxwithspring.domain.persistence;

import java.util.List;

public interface PersistenceUseCase {

	WordRecord post(WordRecord wordRecord);

	List<WordRecord> getAll();

	WordRecord getById(Long id);

	List<WordRecord> getByFilter(String filter);

	WordRecord put(Long id, String newWord);

	void delete(Long id);

}
