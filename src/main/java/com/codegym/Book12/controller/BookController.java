package com.codegym.Book12.controller;

import com.codegym.Book12.model.Book;
import com.codegym.Book12.model.Category;
import com.codegym.Book12.repository.BookRepository;
import com.codegym.Book12.service.BookService;
import com.codegym.Book12.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @ModelAttribute("category")
    public Iterable<Category> categories(){return categoryService.findAll();}


    @GetMapping("/list")
    public ModelAndView showListBook(@PageableDefault(size = 5)Pageable pageable){
        Page<Book> listBook = bookService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("book",listBook);
        return modelAndView;
    }
    @GetMapping("/create-book")
    public ModelAndView formCreateBook(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }
    @PostMapping("/create-book")
    public ModelAndView createBook(@Validated @ModelAttribute("book")Book book,BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("create");
        }else {
            bookService.save(book);
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("book",new Book());
            modelAndView.addObject("message","Create Successfully!");
            return modelAndView;
        }
    }

    @GetMapping("/edit-book/{id}")
    public ModelAndView formUpdateBook(@PathVariable Long id){
        Book book = bookService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("book",book);
        return modelAndView;
    }
    @PostMapping("/edit-book")
    public ModelAndView updateBook(@Validated @ModelAttribute("book")Book book, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("edit");
        }else {
            bookService.save(book);
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("message","Update successfully!");
            return modelAndView;
        }
    }
    @GetMapping("/delete-book/{id}")
    public ModelAndView formDeleteBook(@PathVariable Long id){
        Book book = bookService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("book", book);
        return modelAndView;
    }
    @PostMapping("/delete-book")
    public String deleteBook(@ModelAttribute("book") Book book){
        bookService.delete(book.getId());
        return "redirect:list";
    }
    @GetMapping("/list-search")
    public ModelAndView listSearch(@RequestParam("search") String search, Pageable pageable){
        Page<Book> books = bookService.findByName(search,pageable);
        ModelAndView modelAndView = new ModelAndView("listSearch");
        modelAndView.addObject("search",books);
        return modelAndView;

    }
}
