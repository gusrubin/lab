package com.gusrubin.lab.springgenerallab.domain.runtimescheduling;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Gustavo Rubin
 *
 */
@Slf4j
public class RuntimeScheduleService implements TaskDefinitionCrudUseCase {

    private final TaskDefinitionRepositoryPort taskDefinitionRepositoryPort;
    private final ModelMapper modelMapper;
    private final TaskSchedulingService taskSchedulingService;

    public RuntimeScheduleService(TaskDefinitionRepositoryPort taskDefinitionRepositoryPort, ModelMapper modelMapper,
	    TaskSchedulingService taskSchedulingService) {
	this.taskDefinitionRepositoryPort = taskDefinitionRepositoryPort;
	this.modelMapper = modelMapper;
	this.taskSchedulingService = taskSchedulingService;
    }

    @Override
    public TaskDefinition create(NewTaskDefinition newTaskDefinition) {
	Assert.notNull(newTaskDefinition, "awb object cannot be null");
	Assert.hasLength(newTaskDefinition.getCronExpression(), "cronExpression cannot be null");
	Assert.hasLength(newTaskDefinition.getActionType(), "actionType cannot be null");
	Assert.hasLength(newTaskDefinition.getData(), "data cannot be null");

	TaskDefinition taskDefinition = this.taskDefinitionRepositoryPort
		.save(this.modelMapper.map(newTaskDefinition, TaskDefinition.class));

	TaskDefinitionRunner taskDefinitionRunner = TaskDefinitionRunner.builder().taskDefinition(taskDefinition)
		.build();

	this.taskSchedulingService.scheduleTask(taskDefinition.getId(), taskDefinitionRunner,
		taskDefinition.getCronExpression());

	return taskDefinition;
    }

    @Override
    public List<TaskDefinition> findAll() {
	return this.taskDefinitionRepositoryPort.findAll();
    }

    @Override
    public TaskDefinition findById(Long id) {
	Assert.notNull(id, "id cannot be null.");
	TaskDefinition taskDefinition = this.taskDefinitionRepositoryPort.findById(id);
	Assert.notNull(taskDefinition, "awbAcquirement not registered");

	return taskDefinition;
    }

    @Override
    public TaskDefinition update(Long id, NewTaskDefinition newTaskDefinition) {
	Assert.notNull(newTaskDefinition, "awb object cannot be null");
	Assert.hasLength(newTaskDefinition.getCronExpression(), "cronExpression cannot be null");
	Assert.hasLength(newTaskDefinition.getActionType(), "actionType cannot be null");
	Assert.hasLength(newTaskDefinition.getData(), "data cannot be null");
	TaskDefinition existingTaskDefinition = this.taskDefinitionRepositoryPort.findById(id);
	Assert.notNull(existingTaskDefinition, "task definition not registered");

	TaskDefinition taskDefinition = this.modelMapper.map(newTaskDefinition, TaskDefinition.class);
	taskDefinition.setId(id);

	TaskDefinition updatedTaskDefinition = this.taskDefinitionRepositoryPort.save(taskDefinition);

	this.taskSchedulingService.removeScheduledTask(id);

	TaskDefinitionRunner taskDefinitionRunner = TaskDefinitionRunner.builder().taskDefinition(taskDefinition)
		.build();
	this.taskSchedulingService.scheduleTask(taskDefinition.getId(), taskDefinitionRunner,
		taskDefinition.getCronExpression());

	return updatedTaskDefinition;
    }

    @Override
    public void delete(Long id) {
	Assert.notNull(id, "id cannot be null.");
	TaskDefinition taskDefinition = this.taskDefinitionRepositoryPort.findById(id);
	Assert.notNull(taskDefinition, "task definition not registered");

	this.taskSchedulingService.removeScheduledTask(id);

	this.taskDefinitionRepositoryPort.delete(id);
    }

}
