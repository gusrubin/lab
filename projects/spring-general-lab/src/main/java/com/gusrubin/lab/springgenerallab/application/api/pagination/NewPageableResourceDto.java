/**
 * 
 */
package com.gusrubin.lab.springgenerallab.application.api.pagination;

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
public class NewPageableResourceDto {

    private String text;

}
