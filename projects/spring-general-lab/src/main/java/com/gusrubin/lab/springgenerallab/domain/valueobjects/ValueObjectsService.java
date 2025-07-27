package com.gusrubin.lab.springgenerallab.domain.valueobjects;

public class ValueObjectsService implements ValueObjectsUseCases {

  @Override
  public Email createEmail(String value) {
    return new Email(value);
  }
}
