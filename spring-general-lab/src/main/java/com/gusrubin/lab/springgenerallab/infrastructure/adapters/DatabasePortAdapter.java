/**
 * 
 */
package com.gusrubin.lab.springgenerallab.infrastructure.adapters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gusrubin.lab.springgenerallab.domain.freezingprotection.DatabasePort;
import com.gusrubin.lab.springgenerallab.domain.freezingprotection.LongRunningCallableTask;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Gustavo Rubin
 *
 */
@Slf4j
@Component
@Transactional
public class DatabasePortAdapter implements DatabasePort {

    private final EntityManager entityManager;
    private static final String NO_FREEZING_PROCEDURE_NAME = "generate_message_no_freezing";
    private static final String FREEZING_PROCEDURE_NAME = "generate_message_freezing";
    private static final String REQUEST_ID_PARAMETER = "request_id";
    private static final String MESSAGE_FROM_PROCEDURE_PARAMETER = "generated_message";

    /**
     * @param entityManager
     */
    public DatabasePortAdapter(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    @Override
    public String callProcedureNoFreezing(String requestId) {
	return this.callProcedure(NO_FREEZING_PROCEDURE_NAME, requestId);
    }

    @Override
    public String callProcedureThatFreezes(String requestId) {
	return callProcedure(FREEZING_PROCEDURE_NAME, requestId);
    }

//    private String callProcedure(String procedureName, String requestId) {
//	StoredProcedureQuery query = entityManager.createStoredProcedureQuery(procedureName);
//	query.registerStoredProcedureParameter(REQUEST_ID_PARAMETER, String.class, ParameterMode.IN);
//	query.registerStoredProcedureParameter(MESSAGE_FROM_PROCEDURE_PARAMETER, String.class, ParameterMode.OUT);
//	query.setParameter(REQUEST_ID_PARAMETER, requestId);
//
//	String returnedMessage = null;
//
//	try {
//	    query.execute();
//	    returnedMessage = (String) query.getOutputParameterValue(MESSAGE_FROM_PROCEDURE_PARAMETER);
//
//	} catch (Exception e) {
//	    log.error("Failed to call database procedure {}. Exception={}", MESSAGE_FROM_PROCEDURE_PARAMETER,
//		    e.getLocalizedMessage());
//	    throw new IllegalStateException("Failed to call database procedure " + MESSAGE_FROM_PROCEDURE_PARAMETER);
//	}
//
//	return returnedMessage;
//    }

    private String callProcedure(String procedureName, String requestId) {
	ExecutorService executor = Executors.newSingleThreadExecutor();
	ThreadProtectedCallProcedure callProcedureTask = new ThreadProtectedCallProcedure(this.entityManager,
		procedureName, requestId);
	Future<String> future = executor.submit(callProcedureTask);

	String result = null;

	try {
	    result = future.get(5, TimeUnit.SECONDS);

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

}
