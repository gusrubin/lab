package com.gusrubin.lab.javafxwithspring.domain.persistence;

import java.util.List;

import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersistenceService implements PersistenceUseCase {

	private final PersistenceRepositoryPort persistenceRepositoryPort;

	@Override
	public WordRecord post(WordRecord wordRecord) {
		Assert.notNull(wordRecord, "wordRecord is required");
		Assert.hasLength(wordRecord.getWord(), "word is required");
		wordRecord.setId(null);

		return this.persistenceRepositoryPort.save(wordRecord);
	}

	@Override
	public List<WordRecord> getAll() {
		return this.persistenceRepositoryPort.findAll();
	}

	@Override
	public WordRecord getById(Long id) {
		Assert.notNull(id, "id required");
		var wordRecord = this.persistenceRepositoryPort.findById(id);
		Assert.notNull(wordRecord, "wordRecord not found with id " + id);

		return wordRecord;
	}

	@Override
	public List<WordRecord> getByFilter(String filter) {

		return null;
	}

	@Override
	public WordRecord put(Long id, String newWord) {
		var wordRecord = getById(id);
		wordRecord.setWord(newWord);

		return this.persistenceRepositoryPort.save(wordRecord);
	}

	@Override
	public void delete(Long id) {
		getById(id);
		this.persistenceRepositoryPort.delete(id);
	}

}
