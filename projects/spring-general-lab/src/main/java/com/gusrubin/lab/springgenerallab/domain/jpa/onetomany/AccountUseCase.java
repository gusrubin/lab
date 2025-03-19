package com.gusrubin.lab.springgenerallab.domain.jpa.onetomany;

import java.util.List;

/**
 * @author Gustavo Rubin
 *
 */
public interface AccountUseCase {

    record NewAccount(String name, String email) {
    }

    record NewAccountSetting(String settingName, String settingValue) {
    }

    Account create(NewAccount newAccount);

    List<Account> findAll();

    Account findById(long id);

    Account update(long id, NewAccount newAccount);

    void deleteById(long id);

    Account addAccountSetting(long accountId, NewAccountSetting newAccountSetting);

    Account updateAccountSetting(long accountId, long accountSettingId, NewAccountSetting newAccountSetting);

    void deleteAccountSettingById(long accountId, long accountSettingId);

}
