/**
 * 
 */
package com.gusrubin.lab.springgenerallab.infrastructure.servicebeans;

import org.springframework.stereotype.Service;

import com.gusrubin.lab.springgenerallab.domain.freezingprotection.DatabasePort;
import com.gusrubin.lab.springgenerallab.domain.freezingprotection.FreezingProtectionService;

/**
 * @author Gustavo Rubin
 *
 */
@Service
public class FreezingProtectionServiceBean extends FreezingProtectionService {

    /**
     * @param databasePort
     */
    public FreezingProtectionServiceBean(DatabasePort databasePort) {
	super(databasePort);
    }

}
