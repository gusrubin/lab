/**
 * 
 */
package com.gusrubin.lab.springgenerallab.domain.runtimescheduling;

import java.util.List;

/**
 * @author Gustavo Rubin
 *
 */
public interface TaskDefinitionCrudUseCase {

    TaskDefinition create(NewTaskDefinition newTaskDefinition);

    List<TaskDefinition> findAll();

    TaskDefinition findById(Long id);

    TaskDefinition update(Long id, NewTaskDefinition newTaskDefinition);

    void delete(Long id);

}
