/**
 * 
 */
package com.gusrubin.lab.springgenerallab.domain.runtimescheduling;

import java.util.List;

/**
 * @author Gustavo Rubin
 *
 */
public interface TaskDefinitionRepositoryPort {

    TaskDefinition save(TaskDefinition taskDefinition);

    List<TaskDefinition> findAll();

    TaskDefinition findById(Long id);

    void delete(Long id);

}
