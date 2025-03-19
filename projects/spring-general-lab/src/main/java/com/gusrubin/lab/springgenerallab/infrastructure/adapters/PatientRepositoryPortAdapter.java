package com.gusrubin.lab.springgenerallab.infrastructure.adapters;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.gusrubin.lab.springgenerallab.domain.jpa.onetoone.MedicalRecord;
import com.gusrubin.lab.springgenerallab.domain.jpa.onetoone.Patient;
import com.gusrubin.lab.springgenerallab.domain.jpa.onetoone.PatientRepositoryPort;
import com.gusrubin.lab.springgenerallab.infrastructure.database.entities.MedicalRecordEntity;
import com.gusrubin.lab.springgenerallab.infrastructure.database.entities.PatientEntity;
import com.gusrubin.lab.springgenerallab.infrastructure.database.repositories.PatientRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Gustavo Rubin
 *
 */
@Component
@RequiredArgsConstructor
public class PatientRepositoryPortAdapter implements PatientRepositoryPort {

    final PatientRepository patientRepository;
    final ModelMapper modelMapper;

    @Override
    public Patient save(Patient patient) {
	var patientEntity = toEntity(patient);
	var medicalRecordEntity = toEntity(patient.getMedicalRecord());
	patientEntity.setMedicalRecordEntity(medicalRecordEntity);

	var patientEntityPersisted = this.patientRepository.save(patientEntity);

	var patientPersisted = toDomain(patientEntityPersisted);
	var medicalRecordPersisted = toDomain(patientEntityPersisted.getMedicalRecordEntity());
	patientPersisted.setMedicalRecord(medicalRecordPersisted);

	return patientPersisted;
    }

    @Override
    public List<Patient> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Patient findById(long id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void deleteById(long id) {
	// TODO Auto-generated method stub

    }

    private Patient toDomain(PatientEntity entity) {
	return this.modelMapper.map(entity, Patient.class);
    }

    private PatientEntity toEntity(Patient entity) {
	return this.modelMapper.map(entity, PatientEntity.class);
    }

    private MedicalRecord toDomain(MedicalRecordEntity entity) {
	return this.modelMapper.map(entity, MedicalRecord.class);
    }

    private MedicalRecordEntity toEntity(MedicalRecord entity) {
	return this.modelMapper.map(entity, MedicalRecordEntity.class);
    }

}
