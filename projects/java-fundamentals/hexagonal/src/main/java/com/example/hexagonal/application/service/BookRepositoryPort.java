package com.example.hexagonal.application.service;

import com.example.hexagonal.domain.book.Book;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Gustavo Rubin
 */
public interface BookRepositoryPort {
  Book save(Book book);

  List<Book> findAll();
}
