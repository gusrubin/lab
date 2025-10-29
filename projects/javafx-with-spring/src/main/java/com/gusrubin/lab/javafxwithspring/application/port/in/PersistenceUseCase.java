package com.gusrubin.lab.javafxwithspring.application.port.in;

import com.gusrubin.lab.javafxwithspring.domain.persistence.WordRecord;
import com.gusrubin.lab.javafxwithspring.domain.persistence.WordRecord.WordRecordCreateDto;
import com.gusrubin.lab.javafxwithspring.domain.persistence.WordRecord.WordRecordUpdateDto;
import java.util.List;

public interface PersistenceUseCase {

  WordRecord post(WordRecordCreateDto wordRecordCreateDto);

  List<WordRecord> getAll();

  WordRecord getById(Long id);

  List<WordRecord> getByFilter(String filter);

  WordRecord put(Long id, WordRecordUpdateDto wordRecordUpdateDto);

  void delete(Long id);
}
