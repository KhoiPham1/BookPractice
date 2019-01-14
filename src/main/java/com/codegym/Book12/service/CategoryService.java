package com.codegym.Book12.service;

import com.codegym.Book12.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(Long id);
}
