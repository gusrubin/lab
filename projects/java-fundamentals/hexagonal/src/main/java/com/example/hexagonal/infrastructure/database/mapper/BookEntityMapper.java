package com.example.hexagonal.infrastructure.database.mapper;

import com.example.hexagonal.domain.book.Book;
import com.example.hexagonal.infrastructure.database.entity.BookEntity;

/**
 * @author Gustavo Rubin
 */
public class BookEntityMapper {
  public static BookEntity toEntity(Book book) {
    return new BookEntity(book.getId(), book.getTitle(), book.getAuthor());
  }

  public static Book toDomain(BookEntity entity) {
    return new Book(entity.getId(), entity.getTitle(), entity.getAuthor());
  }
}
