package com.gusrubin.lab.springgenerallab.domain.jpa.onetomany;

import java.util.List;

/**
 * @author Gustavo Rubin
 *
 */
public interface AccountRepositoryPort {

    Account save(Account patient);

    List<Account> findAll();

    Account findById(long id);

    void deleteById(long id);

}
