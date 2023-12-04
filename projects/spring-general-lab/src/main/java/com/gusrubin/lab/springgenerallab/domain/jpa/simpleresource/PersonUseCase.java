package com.gusrubin.lab.springgenerallab.domain.jpa.simpleresource;

import java.util.List;

/**
 * @author Gustavo Rubin
 *
 */
public interface PersonUseCase {

    public record NewPerson(String name, Integer age) {
    }

    Person create(NewPerson newPerson);

    List<Person> findAll();

    Person findById(long id);

    void deleteById(long id);

}
