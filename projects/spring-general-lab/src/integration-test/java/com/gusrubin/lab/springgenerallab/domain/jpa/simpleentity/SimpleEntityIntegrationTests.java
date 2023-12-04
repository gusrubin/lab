package com.gusrubin.lab.springgenerallab.domain.jpa.simpleentity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gusrubin.lab.springgenerallab.domain.jpa.simpleresource.PersonUseCase;
import com.gusrubin.lab.springgenerallab.domain.jpa.simpleresource.PersonUseCase.NewPerson;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Gustavo Rubin
 *
 */
@Slf4j
@SpringBootTest
class SimpleEntityIntegrationTests {

    @Autowired
    PersonUseCase personUseCase;

    private static String getCurrentMethodName() {
	return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    @Test
    void jpaSimpleEntityCreationTest() {
	log.info("Starting test '{}'", getCurrentMethodName());
	// Preconditions
	var newPerson = new NewPerson("Gustavo", 40);

	// Test
	log.info("Creating new person");
	var person = this.personUseCase.create(newPerson);

	// Validations
	log.info("Person created '{}'", person);
	assertEquals(1L, person.getId());
    }

}
