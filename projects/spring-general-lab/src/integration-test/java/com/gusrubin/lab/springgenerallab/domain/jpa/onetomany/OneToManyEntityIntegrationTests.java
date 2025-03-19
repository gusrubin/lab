package com.gusrubin.lab.springgenerallab.domain.jpa.onetomany;

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
class OneToManyEntityIntegrationTests {

    @Autowired
    AccountUseCase accountUseCase;

    private static String getCurrentMethodName() {
	return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    @Test
    void jpaOneToManyEntityCreationTest() {
	log.info("Starting test '{}'", getCurrentMethodName());
	// Preconditions
	var newAccount = new AccountUseCase.NewAccount("Gustavo", "gusrubin@gmail.com");
	var newAccountSetting = new AccountUseCase.NewAccountSetting("Nationality", "Brasilian");

	// Test
	log.info("Creating new account");
	var account = this.accountUseCase.create(newAccount);
	log.info("Account created '{}'", account);

	log.info("Adding setting to account");
	account = this.accountUseCase.addAccountSetting(account.getId(), newAccountSetting);
	log.info("Account after added setting '{}'", account);

	log.info("Deleting setting from account");
	var firstAccountSetting = account.getAccountSettings().get(0);
	this.accountUseCase.deleteAccountSettingById(account.getId(), firstAccountSetting.getId());
	account = this.accountUseCase.findById(account.getId());
	log.info("Account after deleted setting '{}'", account);

	// Validations
	assertEquals(1L, account.getId());
    }

}
