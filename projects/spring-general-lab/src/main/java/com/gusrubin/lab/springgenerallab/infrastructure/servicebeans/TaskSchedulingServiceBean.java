/**
 * 
 */
package com.gusrubin.lab.springgenerallab.infrastructure.servicebeans;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import com.gusrubin.lab.springgenerallab.domain.runtimescheduling.TaskSchedulingService;

/**
 * @author Gustavo Rubin
 *
 */
@Service
public class TaskSchedulingServiceBean extends TaskSchedulingService {

    /**
     * @param taskScheduler
     */
    public TaskSchedulingServiceBean(TaskScheduler taskScheduler) {
	super(taskScheduler);
    }

}
