/**
 * 
 */
package com.gusrubin.lab.pageable.domain;

import java.util.List;

/**
 * @author Gustavo Rubin
 *
 */
public interface ExampleCrudUseCase {

    Example create(Example newExample);

    List<Example> findAll();

    Example findById(Long id);

    Example update(Long id, Example newExample);

    void delete(Long id);

}
