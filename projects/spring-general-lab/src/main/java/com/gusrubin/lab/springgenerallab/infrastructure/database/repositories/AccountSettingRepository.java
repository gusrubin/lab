package com.gusrubin.lab.springgenerallab.infrastructure.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gusrubin.lab.springgenerallab.infrastructure.database.entities.AccountSettingEntity;

/**
 * @author Gustavo Rubin
 *
 */
public interface AccountSettingRepository extends JpaRepository<AccountSettingEntity, Long> {

}
