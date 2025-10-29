package com.gusrubin.lab.javafxwithspring.domain.persistence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class WordRecord {

  private final Long id;
  private String word;

  private WordRecord(Long id, String word) {
    if (word == null || word.isBlank()) {
      throw new IllegalArgumentException("word is required");
    }

    this.id = id;
    this.word = word;
  }

  public record WordRecordCreateDto(String word) {}

  // Factory
  public static WordRecord create(WordRecordCreateDto dto) {
    return new WordRecord(null, dto.word);
  }

  public record WordRecordUpdateDto(String word) {}

  public void update(WordRecordUpdateDto dto) {
    if (dto.word != null && !dto.word.isBlank()) {
      this.word = dto.word;
    }
  }

  // Load values from database
  public static WordRecord restore(Long id, String word) {
    if (id == null) {
      throw new IllegalArgumentException("id is required");
    }
    return new WordRecord(id, word);
  }
}
