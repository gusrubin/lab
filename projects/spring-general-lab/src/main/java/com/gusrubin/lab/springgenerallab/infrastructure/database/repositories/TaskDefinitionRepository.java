/**
 * 
 */
package com.gusrubin.lab.springgenerallab.infrastructure.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gusrubin.lab.springgenerallab.infrastructure.database.entities.TaskDefinitionEntity;

/**
 * @author Gustavo Rubin
 *
 */
public interface TaskDefinitionRepository extends JpaRepository<TaskDefinitionEntity, Long> {

}
