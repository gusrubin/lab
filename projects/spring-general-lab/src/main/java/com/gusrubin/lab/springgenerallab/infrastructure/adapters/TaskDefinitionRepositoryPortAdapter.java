/**
 * 
 */
package com.gusrubin.lab.springgenerallab.infrastructure.adapters;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.gusrubin.lab.springgenerallab.domain.runtimescheduling.TaskDefinition;
import com.gusrubin.lab.springgenerallab.domain.runtimescheduling.TaskDefinitionRepositoryPort;
import com.gusrubin.lab.springgenerallab.infrastructure.database.entities.TaskDefinitionEntity;
import com.gusrubin.lab.springgenerallab.infrastructure.database.repositories.TaskDefinitionRepository;

/**
 * @author Gustavo Rubin
 *
 */
@Component
public class TaskDefinitionRepositoryPortAdapter implements TaskDefinitionRepositoryPort {

    private TaskDefinitionRepository taskDefinitionRepository;
    private final ModelMapper modelMapper;

    /**
     * @param taskDefinitionRepository
     * @param modelMapper
     */
    public TaskDefinitionRepositoryPortAdapter(TaskDefinitionRepository taskDefinitionRepository,
	    ModelMapper modelMapper) {
	this.taskDefinitionRepository = taskDefinitionRepository;
	this.modelMapper = modelMapper;
    }

    @Override
    public TaskDefinition save(TaskDefinition taskDefinition) {
	return toDomain(this.taskDefinitionRepository.save(toEntity(taskDefinition)));
    }

    @Override
    public List<TaskDefinition> findAll() {
	return this.taskDefinitionRepository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public TaskDefinition findById(Long id) {
	TaskDefinitionEntity entity = this.taskDefinitionRepository.findById(id).orElse(null);
	return entity != null ? toDomain(entity) : null;
    }

    @Override
    public void delete(Long id) {
	this.taskDefinitionRepository.deleteById(id);
    }

    private TaskDefinition toDomain(TaskDefinitionEntity entity) {
	return this.modelMapper.map(entity, TaskDefinition.class);
    }

    private TaskDefinitionEntity toEntity(TaskDefinition domain) {
	return this.modelMapper.map(domain, TaskDefinitionEntity.class);
    }

}
