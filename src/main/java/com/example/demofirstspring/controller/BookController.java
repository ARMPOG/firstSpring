package com.example.demofirstspring.controller;

import com.example.demofirstspring.model.Book;
import com.example.demofirstspring.service.AuthorService;
import com.example.demofirstspring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    private BookService bookService;
    private AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addBookView(ModelMap map) {
        map.addAttribute("book", new Book());
        map.addAttribute("authors", authorService.findAll());
        return "addBook";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/addBook";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String books(ModelMap map){
        map.addAttribute("books",bookService.findAll());
        return "allBooks";
    }
}
