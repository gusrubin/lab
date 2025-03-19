package com.gusrubin.lab.springgenerallab.domain.jpa.onetoone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Gustavo Rubin
 *
 */
@Slf4j
@SpringBootTest
class OneToOneEntityIntegrationTests {

    @Autowired
    PatientUseCase patientUseCase;

    private static String getCurrentMethodName() {
	return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    @Test
    void jpaOneToOneEntityCreationTest() {
	log.info("Starting test '{}'", getCurrentMethodName());
	// Preconditions
	var newPatient = new PatientUseCase.NewPatient("Gustavo");

	// Test
	log.info("Creating new patient");
	var patient = this.patientUseCase.create(newPatient);

	// Validations
	log.info("Patient created '{}'", patient);
	assertEquals(1L, patient.getId());
    }

}
