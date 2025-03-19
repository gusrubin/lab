package com.gusrubin.lab.springgenerallab.domain.jpa.onetoone;

import java.util.List;

/**
 * @author Gustavo Rubin
 *
 */
public interface PatientRepositoryPort {

    Patient save(Patient patient);

    List<Patient> findAll();

    Patient findById(long id);

    void deleteById(long id);

}
