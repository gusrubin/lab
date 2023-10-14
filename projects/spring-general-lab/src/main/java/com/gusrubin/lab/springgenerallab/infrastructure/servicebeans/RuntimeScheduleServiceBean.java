/**
 * 
 */
package com.gusrubin.lab.springgenerallab.infrastructure.servicebeans;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.gusrubin.lab.springgenerallab.domain.runtimescheduling.RuntimeScheduleService;
import com.gusrubin.lab.springgenerallab.domain.runtimescheduling.TaskDefinitionRepositoryPort;
import com.gusrubin.lab.springgenerallab.domain.runtimescheduling.TaskSchedulingService;

/**
 * @author Gustavo Rubin
 *
 */
@Service
public class RuntimeScheduleServiceBean extends RuntimeScheduleService {

    /**
     * @param taskDefinitionRepositoryPort
     * @param modelMapper
     * @param taskSchedulingService
     */
    public RuntimeScheduleServiceBean(TaskDefinitionRepositoryPort taskDefinitionRepositoryPort,
	    ModelMapper modelMapper, TaskSchedulingService taskSchedulingService) {
	super(taskDefinitionRepositoryPort, modelMapper, taskSchedulingService);
    }

}
