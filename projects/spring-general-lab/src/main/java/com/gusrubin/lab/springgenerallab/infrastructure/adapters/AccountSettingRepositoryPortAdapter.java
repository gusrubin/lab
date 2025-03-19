package com.gusrubin.lab.springgenerallab.infrastructure.adapters;

import org.springframework.stereotype.Component;

import com.gusrubin.lab.springgenerallab.domain.jpa.onetomany.AccountSetting;
import com.gusrubin.lab.springgenerallab.domain.jpa.onetomany.AccountSettingRepositoryPort;

import lombok.RequiredArgsConstructor;

/**
 * @author Gustavo Rubin
 *
 */
@Component
@RequiredArgsConstructor
public class AccountSettingRepositoryPortAdapter implements AccountSettingRepositoryPort {

    @Override
    public AccountSetting save(AccountSetting accountSetting) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public AccountSetting findById(long id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void deleteById(long id) {
	// TODO Auto-generated method stub

    }

}
