package com.codegym.Book12.service.impl;

import com.codegym.Book12.model.Category;
import com.codegym.Book12.repository.CategoryRepository;
import com.codegym.Book12.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CategoryImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
