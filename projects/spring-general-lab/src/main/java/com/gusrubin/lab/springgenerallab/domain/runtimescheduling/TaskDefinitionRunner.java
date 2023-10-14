/**
 * 
 */
package com.gusrubin.lab.springgenerallab.domain.runtimescheduling;

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
public class TaskDefinitionRunner implements Runnable {

    private TaskDefinition taskDefinition;

    @Override
    public void run() {
	log.info("Running action: " + taskDefinition.getActionType());
	log.info("With Data: " + taskDefinition.getData());
    }

}
