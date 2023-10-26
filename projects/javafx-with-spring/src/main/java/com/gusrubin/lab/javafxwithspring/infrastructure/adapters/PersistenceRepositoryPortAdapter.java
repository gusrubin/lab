package com.gusrubin.lab.javafxwithspring.infrastructure.adapters;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.gusrubin.lab.javafxwithspring.domain.persistence.PersistenceRepositoryPort;
import com.gusrubin.lab.javafxwithspring.domain.persistence.WordRecord;
import com.gusrubin.lab.javafxwithspring.infrastructure.database.entities.WordRecordEntity;
import com.gusrubin.lab.javafxwithspring.infrastructure.database.repositories.WordRecordRepository;

import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PersistenceRepositoryPortAdapter implements PersistenceRepositoryPort {

	private final WordRecordRepository wordRecordRepository;
	private final ModelMapper modelMapper;

	@Override
	public WordRecord save(WordRecord wordRecord) {
		return toDomain(this.wordRecordRepository.save(toEntity(wordRecord)));
	}

	@Override
	public List<WordRecord> findAll() {
		return this.wordRecordRepository.findAll().stream().map(this::toDomain).toList();
	}

	@Override
	public WordRecord findById(Long id) {
		var wordRecordEntity = this.wordRecordRepository.findById(id).orElse(null);
		return wordRecordEntity != null ? toDomain(wordRecordEntity) : null;
	}

	@Override
	public List<WordRecord> findByFilter(String filter) {
		Specification<WordRecordEntity> spec = containsTextInWord(filter);

		return this.wordRecordRepository.findAll(spec).stream().map(this::toDomain).toList();
	}

	public static Specification<WordRecordEntity> containsTextInWord(String text) {
		return (root, query, criteriaBuilder) -> {
			if (text == null || text.isEmpty()) {
				return criteriaBuilder.conjunction();
			}

			String textoLowerCase = text.toLowerCase();
			Predicate predicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("word")),
					"%" + textoLowerCase + "%");

			return predicate;
		};
	}

	@Override
	public void delete(Long id) {
		this.wordRecordRepository.deleteById(id);
	}

	private WordRecord toDomain(WordRecordEntity entity) {
		return this.modelMapper.map(entity, WordRecord.class);
	}

	private WordRecordEntity toEntity(WordRecord domain) {
		return this.modelMapper.map(domain, WordRecordEntity.class);
	}

}
