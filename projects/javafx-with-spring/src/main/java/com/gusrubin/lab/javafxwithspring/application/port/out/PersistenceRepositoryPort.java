package com.gusrubin.lab.javafxwithspring.application.port.out;

import com.gusrubin.lab.javafxwithspring.domain.persistence.WordRecord;
import java.util.List;

public interface PersistenceRepositoryPort {

  WordRecord save(WordRecord wordRecord);

  List<WordRecord> findAll();

  WordRecord findById(Long id);

  List<WordRecord> findByFilter(String filter);

  void delete(Long id);
}
