/**
 * 
 */
package com.gusrubin.lab.springgenerallab.infrastructure.adapters;

import java.util.concurrent.Callable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Gustavo Rubin
 *
 */
@Slf4j
@Data
@Builder
@AllArgsConstructor
public class ThreadProtectedCallProcedure implements Callable<String> {

    private final EntityManager entityManager;
    private final String procedureName;
    private final String requestId;
    private static final String REQUEST_ID_PARAMETER = "request_id";
    private static final String MESSAGE_FROM_PROCEDURE_PARAMETER = "generated_message";

    @Override
    public String call() throws Exception {
	StoredProcedureQuery query = entityManager.createStoredProcedureQuery(procedureName);
	query.registerStoredProcedureParameter(REQUEST_ID_PARAMETER, String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter(MESSAGE_FROM_PROCEDURE_PARAMETER, String.class, ParameterMode.OUT);
	query.setParameter(REQUEST_ID_PARAMETER, requestId);

	String returnedMessage = null;

	try {
	    query.execute();
	    returnedMessage = (String) query.getOutputParameterValue(MESSAGE_FROM_PROCEDURE_PARAMETER);

	} catch (Exception e) {
	    log.error("Failed to call database procedure {}. Exception={}", MESSAGE_FROM_PROCEDURE_PARAMETER,
		    e.getLocalizedMessage());
	    throw new IllegalStateException("Failed to call database procedure " + MESSAGE_FROM_PROCEDURE_PARAMETER);
	}

	return returnedMessage;
    }

}
