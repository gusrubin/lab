package com.gusrubin.lab.javafxwithspring.infrastructure.servicebeans;

import org.springframework.stereotype.Service;

import com.gusrubin.lab.javafxwithspring.domain.persistence.PersistenceRepositoryPort;
import com.gusrubin.lab.javafxwithspring.domain.persistence.PersistenceService;

@Service
public class PersistenceServiceBean extends PersistenceService {

    public PersistenceServiceBean(PersistenceRepositoryPort persistenceRepositoryPort) {
	super(persistenceRepositoryPort);
    }

}
