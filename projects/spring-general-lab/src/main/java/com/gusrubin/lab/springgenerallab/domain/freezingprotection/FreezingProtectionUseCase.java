/**
 * 
 */
package com.gusrubin.lab.springgenerallab.domain.freezingprotection;

/**
 * @author Gustavo Rubin
 *
 */
public interface FreezingProtectionUseCase {
    
    String getJavaMethodThatFreezes();
    
    String callDatabaseProcedure(Boolean freezing);

}
