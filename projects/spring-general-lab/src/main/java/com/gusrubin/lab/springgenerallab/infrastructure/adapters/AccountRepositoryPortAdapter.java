package com.gusrubin.lab.springgenerallab.infrastructure.adapters;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.gusrubin.lab.springgenerallab.domain.jpa.onetomany.Account;
import com.gusrubin.lab.springgenerallab.domain.jpa.onetomany.AccountRepositoryPort;
import com.gusrubin.lab.springgenerallab.domain.jpa.onetomany.AccountSetting;
import com.gusrubin.lab.springgenerallab.infrastructure.database.entities.AccountEntity;
import com.gusrubin.lab.springgenerallab.infrastructure.database.entities.AccountSettingEntity;
import com.gusrubin.lab.springgenerallab.infrastructure.database.repositories.AccountRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Gustavo Rubin
 *
 */
@Component
@RequiredArgsConstructor
public class AccountRepositoryPortAdapter implements AccountRepositoryPort {

    final AccountRepository accountRepository;
    final ModelMapper modelMapper;

    @Override
    public Account save(Account account) {
	return toDomain(this.accountRepository.save(toEntity(account)));
    }

    @Override
    public List<Account> findAll() {
	return this.accountRepository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Account findById(long id) {
	var accountEntity = this.accountRepository.findById(id).orElse(null);
	return accountEntity != null ? toDomain(accountEntity) : null;
    }

    @Override
    public void deleteById(long id) {
	this.accountRepository.deleteById(id);
    }

    private Account toDomain(AccountEntity entity) {
	var account = this.modelMapper.map(entity, Account.class);

	if (!CollectionUtils.isEmpty(entity.getAccountSettingEntities())) {
	    var accountSettings = entity.getAccountSettingEntities().stream()
	    // @formatter:off
		    .map(this::toDomain)
		    .toList(); 
	    // @formatter:on
	    account.setAccountSettings(accountSettings);
	}

	return account;
    }

    private AccountEntity toEntity(Account domain) {
	var accountEntity = this.modelMapper.map(domain, AccountEntity.class);

	if (!CollectionUtils.isEmpty(domain.getAccountSettings())) {
	    var accountSettingEntities = domain.getAccountSettings().stream()
	    // @formatter:off
		    .map(this::toEntity)
		    .toList(); 
	    // @formatter:on
	    accountEntity.setAccountSettingEntities(accountSettingEntities);
	}

	return accountEntity;
    }

    private AccountSetting toDomain(AccountSettingEntity entity) {
	return this.modelMapper.map(entity, AccountSetting.class);
    }

    private AccountSettingEntity toEntity(AccountSetting entity) {
	return this.modelMapper.map(entity, AccountSettingEntity.class);
    }

}
