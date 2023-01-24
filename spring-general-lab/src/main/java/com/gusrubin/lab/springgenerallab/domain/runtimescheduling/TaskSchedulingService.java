/**
 * 
 */
package com.gusrubin.lab.springgenerallab.domain.runtimescheduling;

import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ScheduledFuture;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Gustavo Rubin
 *
 */
@Slf4j
public class TaskSchedulingService implements TaskSchedulingUseCase {

    private final TaskScheduler taskScheduler;
    private final Map<Long, ScheduledFuture<?>> jobsMap;

    /**
     * @param taskScheduler
     * @param jobsMap
     */
    public TaskSchedulingService(TaskScheduler taskScheduler) {
	this.taskScheduler = taskScheduler;
	this.jobsMap = new HashMap<>();
    }

    @Override
    public void scheduleTask(Long jobId, Runnable tasklet, String cronExpression) {
	log.info("Scheduling task with job id: " + jobId + " and cron expression: " + cronExpression);
	ScheduledFuture<?> scheduledTask = taskScheduler.schedule(tasklet,
		new CronTrigger(cronExpression, TimeZone.getTimeZone(TimeZone.getDefault().getID())));
	jobsMap.put(jobId, scheduledTask);
    }

    @Override
    public void removeScheduledTask(Long jobId) {
	ScheduledFuture<?> scheduledTask = jobsMap.get(jobId);
	if (scheduledTask != null) {
	    scheduledTask.cancel(true);
	    jobsMap.put(jobId, null);
	}
    }

}
