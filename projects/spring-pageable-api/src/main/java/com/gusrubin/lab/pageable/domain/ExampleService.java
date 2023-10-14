/**
 * 
 */
package com.gusrubin.lab.pageable.domain;

import java.util.List;

/**
 * @author Gustavo Rubin
 *
 */
public class ExampleService implements ExampleCrudUseCase {

    private ExampleRepositoryPort exampleRepositoryPort;

    public ExampleService(ExampleRepositoryPort exampleRepositoryPort) {
	this.exampleRepositoryPort = exampleRepositoryPort;
    }

    @Override
    public Example create(Example newExample) {
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
    public Example update(Long id, Example newExample) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void delete(Long id) {
	// TODO Auto-generated method stub

    }

}
