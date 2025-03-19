package com.gusrubin.lab.springgenerallab.infrastructure.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gusrubin.lab.springgenerallab.infrastructure.database.entities.PatientEntity;

/**
 * @author Gustavo Rubin
 *
 */
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

}
