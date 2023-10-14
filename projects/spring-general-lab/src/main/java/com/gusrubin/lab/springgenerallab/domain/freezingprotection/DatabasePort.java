/**
 * 
 */
package com.gusrubin.lab.springgenerallab.domain.freezingprotection;

/**
 * @author Gustavo Rubin
 *
 */
public interface DatabasePort {
    
    String callProcedureNoFreezing(String requestId);
    
    String callProcedureThatFreezes(String requestId);

}
