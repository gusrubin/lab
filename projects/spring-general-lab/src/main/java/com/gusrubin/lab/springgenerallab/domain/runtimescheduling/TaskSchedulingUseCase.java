/**
 * 
 */
package com.gusrubin.lab.springgenerallab.domain.runtimescheduling;

/**
 * @author Gustavo Rubin
 *
 */
public interface TaskSchedulingUseCase {

    void scheduleTask(Long jobId, Runnable tasklet, String cronExpression);

    void removeScheduledTask(Long jobId);

}
