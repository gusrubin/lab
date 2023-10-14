/**
 * 
 */
package com.gusrubin.lab.springgenerallab.application.api.runtimescheduling;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.gusrubin.lab.springgenerallab.domain.runtimescheduling.NewTaskDefinition;
import com.gusrubin.lab.springgenerallab.domain.runtimescheduling.TaskDefinition;
import com.gusrubin.lab.springgenerallab.domain.runtimescheduling.TaskDefinitionCrudUseCase;

/**
 * @author Gustavo Rubin
 *
 */
@RestController
@RequestMapping(path = "/api/task-definitions")
public class TaskDefinitionController {

    private final TaskDefinitionCrudUseCase taskDefinitionCrudUseCase;

    /**
     * @param taskDefinitionCrudUseCase
     */
    public TaskDefinitionController(TaskDefinitionCrudUseCase taskDefinitionCrudUseCase) {
	this.taskDefinitionCrudUseCase = taskDefinitionCrudUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDefinition postAwb(@RequestBody NewTaskDefinition newAwbAcquirementEntry) {
	return this.taskDefinitionCrudUseCase.create(newAwbAcquirementEntry);
    }

    @GetMapping
    public List<TaskDefinition> getAllAwb() {
	return this.taskDefinitionCrudUseCase.findAll();
    }

    @GetMapping("/{id}")
    public TaskDefinition getAwbById(@PathVariable("id") Long id) {
	return this.taskDefinitionCrudUseCase.findById(id);
    }

    @PutMapping("/{id}")
    public TaskDefinition putAwbById(@PathVariable("id") Long id,
	    @RequestBody NewTaskDefinition newAwbAcquirementEntry) {
	return this.taskDefinitionCrudUseCase.update(id, newAwbAcquirementEntry);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAwbById(@PathVariable("id") Long id) {
	this.taskDefinitionCrudUseCase.delete(id);
    }

}
