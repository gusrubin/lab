package com.gusrubin.lab.springgenerallab.domain.runtimescheduling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Gustavo Rubin
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDefinition {

    private Long id;
    private String cronExpression;
    private String actionType;
    private String data;

}
