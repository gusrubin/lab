package com.gusrubin.lab.springcacherestapi.infrastructure.user;

import org.springframework.stereotype.Service;

import com.gusrubin.lab.springcacherestapi.domain.user.UserRepositoryPort;
import com.gusrubin.lab.springcacherestapi.domain.user.UserService;

@Service
public class UserServiceAdapter extends UserService {

    public UserServiceAdapter(UserRepositoryPort userRepositoryPort) {
	super(userRepositoryPort);
    }

}
