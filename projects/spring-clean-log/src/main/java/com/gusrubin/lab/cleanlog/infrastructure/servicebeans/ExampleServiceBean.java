/**
 * 
 */
package com.gusrubin.lab.cleanlog.infrastructure.servicebeans;

import org.springframework.stereotype.Service;

import com.gusrubin.lab.cleanlog.domain.ExampleRepositoryPort;
import com.gusrubin.lab.cleanlog.domain.ExampleService;

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
