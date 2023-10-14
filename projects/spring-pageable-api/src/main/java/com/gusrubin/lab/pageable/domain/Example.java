/**
 * 
 */
package com.gusrubin.lab.pageable.domain;

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
public class Example {
    
    private Long id;
    private String value;

}
