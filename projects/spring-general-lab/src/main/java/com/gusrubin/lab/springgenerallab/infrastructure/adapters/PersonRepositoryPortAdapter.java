package com.gusrubin.lab.springgenerallab.infrastructure.adapters;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.gusrubin.lab.springgenerallab.domain.jpa.simpleresource.Person;
import com.gusrubin.lab.springgenerallab.domain.jpa.simpleresource.PersonRepositoryPort;
import com.gusrubin.lab.springgenerallab.domain.jpa.simpleresource.PersonUseCase.NewPerson;
import com.gusrubin.lab.springgenerallab.infrastructure.database.entities.PersonEntity;
import com.gusrubin.lab.springgenerallab.infrastructure.database.repositories.PersonRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Gustavo Rubin
 *
 */
@Component
@RequiredArgsConstructor
public class PersonRepositoryPortAdapter implements PersonRepositoryPort {

    final PersonRepository personRepository;
    final ModelMapper modelMapper;

    @Override
    public Person save(NewPerson newPerson) {
	return toDomain(this.personRepository.save(toEntity(newPerson)));
    }

    @Override
    public List<Person> findAll() {
	return this.personRepository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Person findById(long id) {
	var personOptional = this.personRepository.findById(id);
	return personOptional.isPresent() ? toDomain(personOptional.get()) : null;
    }

    @Override
    public void deleteById(long id) {
	this.personRepository.deleteById(id);
    }

    private Person toDomain(PersonEntity entity) {
	return Person.builder()
	// @formatter:off
		.id(entity.getId())
		.name(entity.getName())
		.age(entity.getAge())
		.build(); 
	// @formatter:on
    }

    private PersonEntity toEntity(NewPerson domain) {
	return PersonEntity.builder()
	// @formatter:off
		.name(domain.name())
		.age(domain.age())
		.build(); 
	// @formatter:on
    }

}
