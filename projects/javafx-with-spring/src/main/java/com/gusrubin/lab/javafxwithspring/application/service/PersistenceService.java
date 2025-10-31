package com.gusrubin.lab.javafxwithspring.application.service;

import com.gusrubin.lab.javafxwithspring.application.port.in.PersistenceUseCase;
import com.gusrubin.lab.javafxwithspring.application.port.out.PersistenceRepositoryPort;
import com.gusrubin.lab.javafxwithspring.domain.persistence.WordRecord;
import com.gusrubin.lab.javafxwithspring.domain.persistence.WordRecord.WordRecordCreateDto;
import com.gusrubin.lab.javafxwithspring.domain.persistence.WordRecord.WordRecordUpdateDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class PersistenceService implements PersistenceUseCase {

  private final PersistenceRepositoryPort persistenceRepositoryPort;

  @Override
  public WordRecord post(WordRecordCreateDto wordRecordCreateDto) {
    Assert.notNull(wordRecordCreateDto, "wordRecordCreateDto is required");
    var wordRecord = WordRecord.create(wordRecordCreateDto);
    return persistenceRepositoryPort.save(wordRecord);
  }

  @Override
  public List<WordRecord> getAll() {
    return persistenceRepositoryPort.findAll();
  }

  @Override
  public WordRecord getById(Long id) {
    Assert.notNull(id, "id required");
    var wordRecord = persistenceRepositoryPort.findById(id);
    Assert.notNull(wordRecord, "wordRecord with id " + id + " not found");

    return wordRecord;
  }

  @Override
  public List<WordRecord> getByFilter(String filter) {
    return persistenceRepositoryPort.findByFilter(filter);
  }

  @Override
  public WordRecord putById(Long id, WordRecordUpdateDto wordRecordUpdateDto) {
    var wordRecord = getById(id);
    wordRecord.update(wordRecordUpdateDto);

    return persistenceRepositoryPort.save(wordRecord);
  }

  @Override
  public void deleteById(Long id) {
    getById(id);
    persistenceRepositoryPort.delete(id);
  }
}
