package com.gusrubin.lab.springgenerallab.domain.jpa.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import lombok.RequiredArgsConstructor;

/**
 * @author Gustavo Rubin
 *
 */
@RequiredArgsConstructor
public class AccountService implements AccountUseCase {

    final AccountRepositoryPort accountRepositoryPort;
    final AccountSettingRepositoryPort accountSettingRepositoryPort;

    @Override
    public Account create(NewAccount newAccount) {
	var account = Account.builder()
	// @formatter:off
		.name(newAccount.name())
		.email(newAccount.email())
		.accountSettings(new ArrayList<>())
		.build(); 
	// @formatter:on
	return this.accountRepositoryPort.save(account);
    }

    @Override
    public List<Account> findAll() {
	return this.accountRepositoryPort.findAll();
    }

    @Override
    public Account findById(long id) {
	var account = this.accountRepositoryPort.findById(id);
	Assert.notNull(account, "There is no account registered with this id");

	return account;
    }

    @Override
    public Account update(long id, NewAccount newAccount) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void deleteById(long id) {
	findById(id);
	this.accountRepositoryPort.deleteById(id);
    }

    @Override
    public Account addAccountSetting(long accountId, NewAccountSetting newAccountSetting) {
	var account = findById(accountId);

	var accountSetting = AccountSetting.builder()
	// @formatter:off
		.settingName(newAccountSetting.settingName())
		.settingValue(newAccountSetting.settingValue())
		.build(); 
	// @formatter:on
	if (CollectionUtils.isEmpty(account.getAccountSettings())) {
	    account.setAccountSettings(new ArrayList<>());
	}

	account.getAccountSettings().add(accountSetting);

	return this.accountRepositoryPort.save(account);
    }

    @Override
    public Account updateAccountSetting(long accountId, long accountSettingId, NewAccountSetting newAccountSetting) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void deleteAccountSettingById(long accountId, long accountSettingId) {
	// TODO Auto-generated method stub

    }

}
