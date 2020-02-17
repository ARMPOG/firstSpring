package com.example.demofirstspring.service;

import com.example.demofirstspring.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    void saveBook(Book book);
}
