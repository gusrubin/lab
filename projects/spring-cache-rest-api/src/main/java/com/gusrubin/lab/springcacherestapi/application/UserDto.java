package com.gusrubin.lab.springcacherestapi.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Data;

@Data
public class UserDto {

    Long id;

    String username;

    @JsonProperty(access = Access.WRITE_ONLY)
    String password;

}
