package com.gusrubin.lab.helloworld.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gusrubin.lab.helloworld.domain.HelloUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/hello-world")
@RequiredArgsConstructor
public class HelloRestController {

    private final HelloUseCase helloUseCase;

    @GetMapping
    public String getMethodName() {
        return this.helloUseCase.getMessage();
    }
    
    
}
