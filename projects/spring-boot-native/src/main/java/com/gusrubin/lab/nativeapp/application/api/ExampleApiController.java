/**
 * 
 */
package com.gusrubin.lab.nativeapp.application.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gustavo Rubin
 *
 */
@RestController
@RequestMapping("/example")
public class ExampleApiController {

    @GetMapping
    public String getExample() {
	return "Hello World from Spring Boot native application!";
    }

}
