package com.codegym.Book12.repository;

import com.codegym.Book12.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book,Long> {
}
