package com.example.hexagonal.infrastructure.adapter;

import com.example.hexagonal.application.service.BookRepositoryPort;
import com.example.hexagonal.domain.book.Book;
import com.example.hexagonal.infrastructure.database.mapper.BookEntityMapper;
import com.example.hexagonal.infrastructure.database.repository.BookJpaRepository;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author Gustavo Rubin
 */
@Component
public class BookRepositoryPortAdapter implements BookRepositoryPort {

  private final BookJpaRepository bookJpaRepository;

  public BookRepositoryPortAdapter(BookJpaRepository bookJpaRepository) {
    this.bookJpaRepository = bookJpaRepository;
  }

  @Override
  public Book save(Book book) {
    return BookEntityMapper.toDomain(bookJpaRepository.save(BookEntityMapper.toEntity(book)));
  }

  @Override
  public List<Book> findAll() {
    return bookJpaRepository.findAll().stream().map(BookEntityMapper::toDomain).toList();
  }
}
