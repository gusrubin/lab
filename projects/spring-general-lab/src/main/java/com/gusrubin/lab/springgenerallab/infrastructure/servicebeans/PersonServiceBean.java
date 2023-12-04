package com.gusrubin.lab.springgenerallab.infrastructure.servicebeans;

import org.springframework.stereotype.Service;

import com.gusrubin.lab.springgenerallab.domain.jpa.simpleresource.PersonRepositoryPort;
import com.gusrubin.lab.springgenerallab.domain.jpa.simpleresource.PersonService;

/**
 * @author Gustavo Rubin
 *
 */
@Service
public class PersonServiceBean extends PersonService {

    /**
     * @param personRepositoryPort
     */
    public PersonServiceBean(PersonRepositoryPort personRepositoryPort) {
	super(personRepositoryPort);
    }

}
