package com.codegym.Book12.repository;

import com.codegym.Book12.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
