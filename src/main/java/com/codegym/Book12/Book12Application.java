package com.codegym.Book12;

import com.codegym.Book12.service.BookService;
import com.codegym.Book12.service.CategoryService;
import com.codegym.Book12.service.impl.BookServiceImpl;
import com.codegym.Book12.service.impl.CategoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Book12Application {

	public static void main(String[] args) {
		SpringApplication.run(Book12Application.class, args);
	}
	@Bean
	public BookService bookService(){return new BookServiceImpl();
	}
	@Bean
	public CategoryService categoryService(){return new CategoryImpl();
	}
}

