package com.example.hexagonal.application.usecase;

import com.example.hexagonal.domain.book.Book;

/**
 * @author Gustavo Rubin
 */
public interface CreateBookUseCase {

  Book create(String title, String author);
}
