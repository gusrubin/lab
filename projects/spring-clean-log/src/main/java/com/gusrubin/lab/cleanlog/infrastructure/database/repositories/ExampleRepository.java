/**
 * 
 */
package com.gusrubin.lab.cleanlog.infrastructure.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gusrubin.lab.cleanlog.infrastructure.database.entities.ExampleEntity;

/**
 * @author Gustavo Rubin
 *
 */
public interface ExampleRepository extends JpaRepository<ExampleEntity, Long> {

}
