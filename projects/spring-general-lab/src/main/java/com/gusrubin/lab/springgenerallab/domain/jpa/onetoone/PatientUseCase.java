package com.gusrubin.lab.springgenerallab.domain.jpa.onetoone;

import java.util.List;

/**
 * @author Gustavo Rubin
 *
 */
public interface PatientUseCase {

    record NewPatient(String name) {
    }

    record NewMedicalRecord(String descriptionOfLastVisit) {
    }

    Patient create(NewPatient newPatient);

    List<Patient> findAll();

    Patient findById(long id);

    Patient updateMedicalRecord(long patientId, NewMedicalRecord newMedicalRecord);

    void deleteById(long id);

}
