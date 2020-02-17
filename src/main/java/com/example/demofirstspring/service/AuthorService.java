package com.example.demofirstspring.service;

import com.example.demofirstspring.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAllBySurname (String surname);
    Author findByEmail(String email);
    List<Author> findAllBySurnameAndAge(String surname, int age);
    List<Author> findAll();
    void saveAuthor(Author author);
    void deleteById (int id);
}
