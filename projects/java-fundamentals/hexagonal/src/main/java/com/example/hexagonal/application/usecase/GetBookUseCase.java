package com.example.hexagonal.application.usecase;

import com.example.hexagonal.domain.book.Book;
import java.util.List;
import java.util.UUID;

/**
 * @author Gustavo Rubin
 */
public interface GetBookUseCase {

  List<Book> listAll();
}
