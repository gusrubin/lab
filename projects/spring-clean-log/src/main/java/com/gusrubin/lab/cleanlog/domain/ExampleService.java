/**
 * 
 */
package com.gusrubin.lab.cleanlog.domain;

import java.util.List;

import org.springframework.util.Assert;

import com.gusrubin.lab.cleanlog.application.api.example.NewExampleDto;

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
    public Example create(NewExampleDto newExampleDto) {
	Assert.hasLength(newExampleDto.getContent(), "valeu cannot be blank");
	Example example = Example.builder().content(newExampleDto.getContent()).build();

	return this.exampleRepositoryPort.save(example);
    }

    @Override
    public List<Example> findAll() {
	return this.exampleRepositoryPort.findAll();
    }

    @Override
    public Example findById(Long id) {
	Example example = this.exampleRepositoryPort.findById(id);
	Assert.notNull(example, "example not registered");
	
	return example;
    }

    @Override
    public Example update(Long id, NewExampleDto newExampleDto) {
	Example example = this.exampleRepositoryPort.findById(id);
	Assert.notNull(example, "example not registered");

	Assert.hasLength(newExampleDto.getContent(), "valeu cannot be blank");

	example.setContent(newExampleDto.getContent());

	return this.exampleRepositoryPort.save(example);
    }

    @Override
    public void delete(Long id) {
	Example example = this.exampleRepositoryPort.findById(id);
	Assert.notNull(example, "example not registered");

	this.exampleRepositoryPort.delete(id);
    }

}
