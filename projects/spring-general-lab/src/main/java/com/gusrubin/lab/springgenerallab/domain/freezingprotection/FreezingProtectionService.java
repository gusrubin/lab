/**
 * 
 */
package com.gusrubin.lab.springgenerallab.domain.freezingprotection;

//import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Gustavo Rubin
 *
 */
@Slf4j
public class FreezingProtectionService implements FreezingProtectionUseCase {

    private final DatabasePort databasePort;
    private int requestIdCounter = 1;

    /**
     * @param databasePort
     */
    public FreezingProtectionService(DatabasePort databasePort) {
	this.databasePort = databasePort;
    }

    @Override
    public String getJavaMethodThatFreezes() {
	// 1#
//	long start = System.currentTimeMillis();
//	long end = start + 30 * 1000;
//	while (System.currentTimeMillis() < end) {
//	    // Some expensive operation on the item.
//	}

	// 2#
//	LongRunningTask task = new LongRunningTask();
//	task.run();

	// 3#
//	Thread thread = new Thread(new LongRunningTask());
//	thread.start();
//
//	Timer timer = new Timer();
//	TimeOutTask timeOutTask = new TimeOutTask(thread, timer);
//	timer.schedule(timeOutTask, 1000);

	// 4#
//	ExecutorService executor = Executors.newSingleThreadExecutor();
//	Future<?> future = executor.submit(new LongRunningTask());
//
//	try {
//	    future.get(4, TimeUnit.SECONDS);
//
//	} catch (TimeoutException e) {
//	    log.error("time out exception");
//	    future.cancel(true);
//
//	} catch (Exception e) {
//	    log.error("other exception");
//	    throw new IllegalStateException(e.getMessage());
//
//	} finally {
//	    executor.shutdownNow();
//	}

	// 5#
//	ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
//	Future<?> future = executor.submit(new LongRunningTask());
//	Runnable cancelTask = () -> future.cancel(true);
//
//	executor.schedule(cancelTask, 4, TimeUnit.SECONDS);
//	executor.shutdown();

	// 6#
	ExecutorService executor = Executors.newSingleThreadExecutor();
	LongRunningCallableTask task = new LongRunningCallableTask();
	Future<String> future = executor.submit(task);

	String result = null;

	try {
	    result = future.get(15, TimeUnit.SECONDS);

	} catch (TimeoutException e) {
	    log.error("time out exception");
	    future.cancel(true);

	} catch (Exception e) {
	    log.error("other exception");
	    throw new IllegalStateException(e.getMessage());

	} finally {
	    executor.shutdownNow();
	}

	return result;
    }

    @Override
    public String callDatabaseProcedure(Boolean freezing) {
	String requestId = String.valueOf(requestIdCounter++);
	String response = null;

	try {
	    if (Boolean.TRUE.equals(freezing)) {
		response = this.databasePort.callProcedureThatFreezes(requestId);

	    } else {
		response = this.databasePort.callProcedureNoFreezing(requestId);
	    }
	    
	} catch (Exception e) {
	    response = "Time out na chamada da procedure";
	    log.error("Time out na chamada da procedure");
	}

	return response;
    }

}
