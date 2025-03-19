package com.gusrubin.lab.springgenerallab.infrastructure.servicebeans;

import org.springframework.stereotype.Service;

import com.gusrubin.lab.springgenerallab.domain.jpa.onetomany.AccountRepositoryPort;
import com.gusrubin.lab.springgenerallab.domain.jpa.onetomany.AccountService;
import com.gusrubin.lab.springgenerallab.domain.jpa.onetomany.AccountSettingRepositoryPort;

/**
 * @author Gustavo Rubin
 *
 */
@Service
public class AccountServiceBean extends AccountService {

    /**
     * @param accountRepositoryPort
     * @param accountSettingRepositoryPort
     */
    public AccountServiceBean(AccountRepositoryPort accountRepositoryPort,
	    AccountSettingRepositoryPort accountSettingRepositoryPort) {
	super(accountRepositoryPort, accountSettingRepositoryPort);
    }

}
