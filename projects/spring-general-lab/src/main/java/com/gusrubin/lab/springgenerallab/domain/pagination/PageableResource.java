/**
 * 
 */
package com.gusrubin.lab.springgenerallab.domain.pagination;

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
public class PageableResource {
    
    private Long id;
    private String text;

}
