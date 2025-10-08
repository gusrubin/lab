package com.gusrubin.lab.javafxwithspring.infrastructure.database.mapper;

import com.gusrubin.lab.javafxwithspring.domain.persistence.WordRecord;
import com.gusrubin.lab.javafxwithspring.infrastructure.database.entities.WordRecordEntity;
import org.mapstruct.Mapper;

/**
 * @author Gustavo Rubin
 */
@Mapper(componentModel = "spring")
public interface WordRecordEntityMapper {

  WordRecordEntity toEntity(WordRecord domain);

  WordRecord toDomain(WordRecordEntity entity);
}
