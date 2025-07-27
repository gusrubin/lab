package com.gusrubin.lab.springgenerallab.application.api.valueobjects;

import com.gusrubin.lab.springgenerallab.domain.valueobjects.Email;
import com.gusrubin.lab.springgenerallab.domain.valueobjects.ValueObjectsUseCases;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/value-objects")
@RequiredArgsConstructor
public class ValueObjectsController {

  private final ValueObjectsUseCases valueObjectsUseCases;

  @PostMapping("/emails")
  public Email post(@RequestBody CreateEmailRequestDto requestDto) {
    return this.valueObjectsUseCases.createEmail(requestDto.value());
  }
}
