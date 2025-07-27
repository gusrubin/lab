package com.example.hexagonal.domain.book;

import java.util.UUID;

/**
 * @author Gustavo Rubin
 */
public class Book {
  private UUID id;
  private String title;
  private String author;

  public Book() {}

  public Book(UUID id, String title, String author) {
    this.id = id;
    this.title = title;
    this.author = author;
  }

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }
}
