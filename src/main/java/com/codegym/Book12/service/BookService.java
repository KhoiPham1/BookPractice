package com.codegym.Book12.service;

import com.codegym.Book12.model.Book;
import com.codegym.Book12.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);

    Page<Book> findAllByBooksCodeContains(String name, Pageable pageable);

    Book findById (Long id);

    void save (Book book);

    void delete (Long id);
}
