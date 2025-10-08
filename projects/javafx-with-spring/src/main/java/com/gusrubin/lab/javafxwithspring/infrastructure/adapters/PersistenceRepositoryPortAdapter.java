package com.gusrubin.lab.javafxwithspring.infrastructure.adapters;

import com.gusrubin.lab.javafxwithspring.domain.persistence.PersistenceRepositoryPort;
import com.gusrubin.lab.javafxwithspring.domain.persistence.WordRecord;
import com.gusrubin.lab.javafxwithspring.infrastructure.database.entities.WordRecordEntity;
import com.gusrubin.lab.javafxwithspring.infrastructure.database.mapper.WordRecordEntityMapper;
import com.gusrubin.lab.javafxwithspring.infrastructure.database.repositories.WordRecordRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersistenceRepositoryPortAdapter implements PersistenceRepositoryPort {

  private final WordRecordRepository wordRecordRepository;
  private final WordRecordEntityMapper wordRecordEntityMapper;

  @Override
  public WordRecord save(WordRecord wordRecord) {
    return toDomain(wordRecordRepository.save(toEntity(wordRecord)));
  }

  @Override
  public List<WordRecord> findAll() {
    return wordRecordRepository.findAll().stream().map(this::toDomain).toList();
  }

  @Override
  public WordRecord findById(Long id) {
    var wordRecordEntity = wordRecordRepository.findById(id).orElse(null);
    return wordRecordEntity != null ? toDomain(wordRecordEntity) : null;
  }

  @Override
  public List<WordRecord> findByFilter(String filter) {
    Specification<WordRecordEntity> spec = containsTextInWord(filter);

    return wordRecordRepository.findAll(spec).stream().map(this::toDomain).toList();
  }

  public static Specification<WordRecordEntity> containsTextInWord(String text) {
    return (root, query, criteriaBuilder) -> {
      if (text == null || text.isEmpty()) {
        return criteriaBuilder.conjunction();
      }

      String textoLowerCase = text.toLowerCase();

      return criteriaBuilder.like(
          criteriaBuilder.lower(root.get("word")), "%" + textoLowerCase + "%");
    };
  }

  @Override
  public void delete(Long id) {
    wordRecordRepository.deleteById(id);
  }

  private WordRecord toDomain(WordRecordEntity entity) {
    return wordRecordEntityMapper.toDomain(entity);
  }

  private WordRecordEntity toEntity(WordRecord domain) {
    return wordRecordEntityMapper.toEntity(domain);
  }
}
