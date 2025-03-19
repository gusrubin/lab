package com.gusrubin.lab.springgenerallab.domain.jpa.onetoone;

import java.util.List;

import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;

/**
 * @author Gustavo Rubin
 *
 */
@RequiredArgsConstructor
public class PatientService implements PatientUseCase {

    final PatientRepositoryPort patientRepositoryPort;

    @Override
    public Patient create(NewPatient newPatient) {
	var patient = Patient.builder()
	// @formatter:off
		.name(newPatient.name())
		.medicalRecord(MedicalRecord.builder().build())
		.build(); 
	// @formatter:on
	return this.patientRepositoryPort.save(patient);
    }

    @Override
    public List<Patient> findAll() {
	return this.patientRepositoryPort.findAll();
    }

    @Override
    public Patient findById(long id) {
	var patient = this.patientRepositoryPort.findById(id);
	Assert.notNull(patient, "There is no patient registered with this id");

	return patient;
    }

    @Override
    public Patient updateMedicalRecord(long patientId, NewMedicalRecord newMedicalRecord) {
	var patient = findById(patientId);
	var medicalRecord = MedicalRecord.builder()
	// @formatter:off
		.descriptionOfLastVisit(newMedicalRecord.descriptionOfLastVisit())
		.build(); 
	// @formatter:on
	patient.setMedicalRecord(medicalRecord);

	return this.patientRepositoryPort.save(patient);
    }

    @Override
    public void deleteById(long id) {
	findById(id);
	this.patientRepositoryPort.deleteById(id);
    }

}
