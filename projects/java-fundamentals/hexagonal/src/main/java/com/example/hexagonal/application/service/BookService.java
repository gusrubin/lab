package com.example.hexagonal.application.service;

import com.example.hexagonal.application.usecase.CreateBookUseCase;
import com.example.hexagonal.application.usecase.GetBookUseCase;
import com.example.hexagonal.domain.book.Book;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Gustavo Rubin
 */
@Service
public class BookService implements CreateBookUseCase, GetBookUseCase {

  private final BookRepositoryPort bookRepositoryPort;

  public BookService(BookRepositoryPort bookRepositoryPort) {
    this.bookRepositoryPort = bookRepositoryPort;
  }

  @Override
  public Book create(String title, String author) {
    return bookRepositoryPort.save(new Book(null, title, author));
  }

  @Override
  public List<Book> listAll() {
    return bookRepositoryPort.findAll();
  }
}
