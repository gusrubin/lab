/**
 * 
 */
package com.gusrubin.lab.cleanlog.infrastructure.adapters;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gusrubin.lab.cleanlog.domain.Example;
import com.gusrubin.lab.cleanlog.domain.ExampleRepositoryPort;
import com.gusrubin.lab.cleanlog.infrastructure.database.entities.ExampleEntity;
import com.gusrubin.lab.cleanlog.infrastructure.database.repositories.ExampleRepository;

/**
 * @author Gustavo Rubin
 *
 */
@Transactional
@Component
public class ExampleRepositoryPortAdapter implements ExampleRepositoryPort {

    private final ExampleRepository exampleRepository;
    private final ModelMapper modelMapper;

    public ExampleRepositoryPortAdapter(ExampleRepository exampleRepository, ModelMapper modelMapper) {
	this.exampleRepository = exampleRepository;
	this.modelMapper = modelMapper;
    }

    @Override
    public Example save(Example newExample) {
	return toDomain(this.exampleRepository.save(toEntity(newExample)));
    }

    @Override
    public List<Example> findAll() {
	return this.exampleRepository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Example findById(Long id) {
	ExampleEntity entity = this.exampleRepository.findById(id).orElse(null);
	return entity != null ? toDomain(entity) : null;
    }

    @Override
    public void delete(Long id) {
	this.exampleRepository.deleteById(id);
    }

    private Example toDomain(ExampleEntity entity) {
	return this.modelMapper.map(entity, Example.class);
    }

    private ExampleEntity toEntity(Example domain) {
	return this.modelMapper.map(domain, ExampleEntity.class);
    }

}
