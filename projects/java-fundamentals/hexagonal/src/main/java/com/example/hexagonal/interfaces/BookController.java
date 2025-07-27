package com.example.hexagonal.interfaces;

import com.example.hexagonal.application.usecase.CreateBookUseCase;
import com.example.hexagonal.application.usecase.GetBookUseCase;
import com.example.hexagonal.domain.book.Book;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gustavo Rubin
 */
@RestController
@RequestMapping("/books")
public class BookController {

  private final CreateBookUseCase createBookUseCase;
  private final GetBookUseCase getBookUseCase;

  public BookController(CreateBookUseCase createBookUseCase, GetBookUseCase getBookUseCase) {
    this.createBookUseCase = createBookUseCase;
    this.getBookUseCase = getBookUseCase;
  }

  @PostMapping
  public Book create(@RequestBody Book book) {
    return createBookUseCase.create(book.getTitle(), book.getAuthor());
  }

  @GetMapping
  public List<Book> list() {
    return getBookUseCase.listAll();
  }
}
