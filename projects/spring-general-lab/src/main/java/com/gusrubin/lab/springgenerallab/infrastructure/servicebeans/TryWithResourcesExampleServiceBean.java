package com.gusrubin.lab.springgenerallab.infrastructure.servicebeans;

import org.springframework.stereotype.Service;

import com.gusrubin.lab.springgenerallab.domain.trywithresources.TryWithResourcesExampleRepositoryPort;
import com.gusrubin.lab.springgenerallab.domain.trywithresources.TryWithResourcesExampleService;

/**
 * @author Gustavo Rubin
 *
 */
@Service
public class TryWithResourcesExampleServiceBean extends TryWithResourcesExampleService {

    public TryWithResourcesExampleServiceBean(
	    TryWithResourcesExampleRepositoryPort tryWithResourcesExampleRepositoryPort) {
	super(tryWithResourcesExampleRepositoryPort);
    }

}
