package com.gusrubin.lab.springgenerallab.domain.jpa.simpleresource;

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
public class Person {

    Long id;
    String name;
    Integer age;

}
