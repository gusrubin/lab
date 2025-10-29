package com.gusrubin.lab.javafxwithspring.infrastructure.database.repositories;

import com.gusrubin.lab.javafxwithspring.infrastructure.database.entities.WordRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WordRecordRepository
    extends JpaRepository<WordRecordEntity, Long>, JpaSpecificationExecutor<WordRecordEntity> {}
