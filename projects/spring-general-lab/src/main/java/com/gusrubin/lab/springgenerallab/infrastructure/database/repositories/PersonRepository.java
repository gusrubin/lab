/**
 * 
 */
package com.gusrubin.lab.springgenerallab.infrastructure.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gusrubin.lab.springgenerallab.infrastructure.database.entities.PersonEntity;

/**
 * @author Gustavo Rubin
 *
 */
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

}
