package com.gusrubin.lab.springgenerallab.domain.jpa.simpleresource;

import java.util.List;

import com.gusrubin.lab.springgenerallab.domain.jpa.simpleresource.PersonUseCase.NewPerson;

/**
 * @author Gustavo Rubin
 *
 */
public interface PersonRepositoryPort {

    Person save(NewPerson newPerson);

    List<Person> findAll();

    Person findById(long id);

    void deleteById(long id);

}
