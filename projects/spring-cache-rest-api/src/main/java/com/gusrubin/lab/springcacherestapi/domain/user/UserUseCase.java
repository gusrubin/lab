package com.gusrubin.lab.springcacherestapi.domain.user;

import java.util.List;

public interface UserUseCase {

    List<User> findAll();

    User findById(Long id);

    User create(User user, String password);

    void deleteById(Long id);

}
