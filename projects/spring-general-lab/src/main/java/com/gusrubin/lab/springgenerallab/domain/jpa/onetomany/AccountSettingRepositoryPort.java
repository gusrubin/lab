package com.gusrubin.lab.springgenerallab.domain.jpa.onetomany;

/**
 * @author Gustavo Rubin
 *
 */
public interface AccountSettingRepositoryPort {

    AccountSetting save(AccountSetting accountSetting);

    AccountSetting findById(long id);

    void deleteById(long id);

}
