/**
 * 
 */
package com.gusrubin.lab.springgenerallab.application.api.freezingprotection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gusrubin.lab.springgenerallab.domain.freezingprotection.FreezingProtectionUseCase;

/**
 * @author Gustavo Rubin
 *
 */
@RestController
@RequestMapping("/api/freezing-protection")
public class FreezingProtectionController {

    private final FreezingProtectionUseCase freezingProtectionUseCase;

    /**
     * @param freezingProtectionUseCase
     */
    public FreezingProtectionController(FreezingProtectionUseCase freezingProtectionUseCase) {
	this.freezingProtectionUseCase = freezingProtectionUseCase;
    }

    @GetMapping("/java-method-that-freezes")
    public String getJavaMethodThatFreezes() {
	return this.freezingProtectionUseCase.getJavaMethodThatFreezes();
    }

    @GetMapping("/database-call-procedure")
    public String getCallDatabaseProcedure(@RequestParam("freezes") Boolean freezes) {
	return this.freezingProtectionUseCase.callDatabaseProcedure(freezes);
    }

}
