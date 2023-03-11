/**
 * 
 */
package com.gusrubin.lab.cleanlog.application.api.example;

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
public class NewExampleDto {

    private String content;

}
