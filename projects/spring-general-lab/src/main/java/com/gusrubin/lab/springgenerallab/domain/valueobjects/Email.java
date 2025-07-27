package com.gusrubin.lab.springgenerallab.domain.valueobjects;

import java.util.Objects;
import java.util.regex.Pattern;

public class Email {

  private final String value;
  private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");

  public Email(String value) {
    if (!isValid(value)) {
      throw new IllegalArgumentException("Email inválido: " + value);
    }
    this.value = value;
  }

  private boolean isValid(String email) {
    return EMAIL_PATTERN.matcher(email).matches();
  }

  public String getValue() {
    return value;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Email other)) return false;
    return value.equals(other.value);
  }

  public int hashCode() {
    return Objects.hash(value);
  }

  public String toString() {
    return value;
  }
}
