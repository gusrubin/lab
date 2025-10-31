package com.gusrubin.lab.javafxwithspring.domain.callexternalapi;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class ExampleResource {

  private final Long id;
  private String message;

  private ExampleResource(Long id, String message) {
    if (message == null || message.isBlank()) {
      throw new IllegalArgumentException("message is required");
    }

    this.id = id;
    this.message = message;
  }

  public record ExampleResourceCreateDto(String message) {}

  // Factory
  public static ExampleResource create(ExampleResourceCreateDto dto) {
    return new ExampleResource(null, dto.message);
  }

  public record ExampleResourceUpdateDto(String message) {}

  public void update(ExampleResourceUpdateDto dto) {
    if (dto.message != null && !dto.message.isBlank()) {
      this.message = dto.message;
    }
  }

  // Load values from database
  public static ExampleResource restore(Long id, String message) {
    if (id == null) {
      throw new IllegalArgumentException("id is required");
    }
    return new ExampleResource(id, message);
  }
}
