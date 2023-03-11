/**
 * 
 */
package com.gusrubin.lab.pageable.domain;

import java.util.List;

/**
 * @author Gustavo Rubin
 *
 */
public interface ExampleRepositoryPort {

    Example save(Example newExample);

    List<Example> findAll();

    Example findById(Long id);

    void delete(Long id);

}
