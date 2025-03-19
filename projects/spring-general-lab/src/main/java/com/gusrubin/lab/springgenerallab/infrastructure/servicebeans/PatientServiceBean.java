package com.gusrubin.lab.springgenerallab.infrastructure.servicebeans;

import org.springframework.stereotype.Service;

import com.gusrubin.lab.springgenerallab.domain.jpa.onetoone.PatientRepositoryPort;
import com.gusrubin.lab.springgenerallab.domain.jpa.onetoone.PatientService;

/**
 * @author Gustavo Rubin
 *
 */
@Service
public class PatientServiceBean extends PatientService {

    /**
     * @param patientRepositoryPort
     */
    public PatientServiceBean(PatientRepositoryPort patientRepositoryPort) {
	super(patientRepositoryPort);
    }

}
