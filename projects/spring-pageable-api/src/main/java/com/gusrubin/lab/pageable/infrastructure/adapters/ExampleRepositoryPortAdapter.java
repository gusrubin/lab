/**
 * 
 */
package com.gusrubin.lab.pageable.infrastructure.adapters;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gusrubin.lab.pageable.domain.Example;
import com.gusrubin.lab.pageable.domain.ExampleRepositoryPort;

/**
 * @author Gustavo Rubin
 *
 */
@Component
public class ExampleRepositoryPortAdapter implements ExampleRepositoryPort {

    @Override
    public Example save(Example newExample) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<Example> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Example findById(Long id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void delete(Long id) {
	// TODO Auto-generated method stub

    }

}
