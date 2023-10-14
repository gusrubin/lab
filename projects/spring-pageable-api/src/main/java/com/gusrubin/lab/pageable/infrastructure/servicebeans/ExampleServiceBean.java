/**
 * 
 */
package com.gusrubin.lab.pageable.infrastructure.servicebeans;

import org.springframework.stereotype.Service;

import com.gusrubin.lab.pageable.domain.ExampleRepositoryPort;
import com.gusrubin.lab.pageable.domain.ExampleService;

/**
 * @author Gustavo Rubin
 *
 */
@Service
public class ExampleServiceBean extends ExampleService {

    public ExampleServiceBean(ExampleRepositoryPort exampleRepositoryPort) {
	super(exampleRepositoryPort);
    }

}
