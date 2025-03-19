package com.gusrubin.lab.springgenerallab.infrastructure.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gusrubin.lab.springgenerallab.infrastructure.database.entities.AccountEntity;

/**
 * @author Gustavo Rubin
 *
 */
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

}
