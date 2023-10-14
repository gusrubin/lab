/**
 * 
 */
package com.gusrubin.lab.cleanlog.domain;

import java.util.List;

import com.gusrubin.lab.cleanlog.application.api.example.NewExampleDto;

/**
 * @author Gustavo Rubin
 *
 */
public interface ExampleCrudUseCase {

    Example create(NewExampleDto newExampleDto);

    List<Example> findAll();

    Example findById(Long id);

    Example update(Long id, NewExampleDto newExampleDto);

    void delete(Long id);

}
