package com.gusrubin.lab.springcacherestapi.domain.user;

import java.util.List;

public interface UserRepositoryPort {

    List<User> findAll();

    User findById(Long id);

    User create(User user);

    void deleteById(Long id);

}
