package com.gusrubin.lab.springgenerallab.domain.jpa.simpleresource;

import java.util.List;

import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;

/**
 * @author Gustavo Rubin
 *
 */
@RequiredArgsConstructor
public class PersonService implements PersonUseCase {

    final PersonRepositoryPort personRepositoryPort;

    @Override
    public Person create(NewPerson newPerson) {
	Assert.hasLength(newPerson.name(), "Name is required");
	Assert.notNull(newPerson.age(), "Age is required");

	return this.personRepositoryPort.save(newPerson);
    }

    @Override
    public List<Person> findAll() {
	return this.personRepositoryPort.findAll();
    }

    @Override
    public Person findById(long id) {
	return this.personRepositoryPort.findById(id);
    }

    @Override
    public void deleteById(long id) {
	this.personRepositoryPort.deleteById(id);
    }

}
