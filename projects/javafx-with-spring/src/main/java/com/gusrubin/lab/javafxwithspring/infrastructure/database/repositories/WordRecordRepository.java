package com.gusrubin.lab.javafxwithspring.infrastructure.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gusrubin.lab.javafxwithspring.infrastructure.database.entities.WordRecordEntity;

public interface WordRecordRepository
		extends JpaRepository<WordRecordEntity, Long>, JpaSpecificationExecutor<WordRecordEntity> {

}
