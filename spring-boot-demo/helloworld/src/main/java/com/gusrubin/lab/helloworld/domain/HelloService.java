package com.gusrubin.lab.helloworld.domain;

public class HelloService implements HelloUseCase {

    private static final String MESSAGE = "Olá mundo!";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
    

}
