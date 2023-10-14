/**
 * 
 */
package com.gusrubin.lab.springgenerallab.application.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.gusrubin.lab.springgenerallab.domain.freezingprotection.FreezingProtectionUseCase;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Gustavo Rubin
 *
 */
@Slf4j
@Service
public class FreezingProtectionPoolingService {

    private final FreezingProtectionUseCase freezingProtectionUseCase;

    /**
     * @param freezingProtectionUseCase
     */
    public FreezingProtectionPoolingService(FreezingProtectionUseCase freezingProtectionUseCase) {
	this.freezingProtectionUseCase = freezingProtectionUseCase;
    }

//    @Scheduled(fixedRate = 15000)
    public void querySendMessage() {
	try {
	    log.debug("Scheduled call to freezingProtectionUseCase.callDatabaseProcedure(freezes)");
	    String result = this.freezingProtectionUseCase.callDatabaseProcedure(true);
	    log.info("Result = {}", result);

	} catch (Exception e) {
	    log.debug("Exception on calling freezingProtectionUseCase.callDatabaseProcedure(freezes)");
	}
    }

}
