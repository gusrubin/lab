/**
 * 
 */
package com.gusrubin.lab.cleanlog.application.api.example;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gusrubin.lab.cleanlog.domain.Example;
import com.gusrubin.lab.cleanlog.domain.ExampleCrudUseCase;

/**
 * @author Gustavo Rubin
 *
 */
@RestController
@RequestMapping("/api/examples")
public class ExampleController {

    private final ExampleCrudUseCase exampleCrudUseCase;

    public ExampleController(ExampleCrudUseCase exampleCrudUseCase) {
	this.exampleCrudUseCase = exampleCrudUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Example postExample(@RequestBody NewExampleDto newExampleDto) {
	return this.exampleCrudUseCase.create(newExampleDto);
    }

    @GetMapping
    public List<Example> getAllExamples() {
	return this.exampleCrudUseCase.findAll();
    }

    @GetMapping("/{id}")
    public Example getExampleById(@RequestParam("id") Long id) {
	return this.exampleCrudUseCase.findById(id);
    }

    @PutMapping("/{id}")
    public Example putExample(@RequestParam("id") Long id, @RequestBody NewExampleDto newExampleDto) {
	return this.exampleCrudUseCase.update(id, newExampleDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExample(@RequestParam("id") Long id) {
	this.exampleCrudUseCase.delete(id);
    }

}
