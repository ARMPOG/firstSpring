package com.example.demofirstspring.service.impl;

import com.example.demofirstspring.model.Author;
import com.example.demofirstspring.repository.AuthorRepository;
import com.example.demofirstspring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAllBySurname(String surname) {
       return authorRepository.findAllBySurname(surname);
    }

    @Override
    public Author findByEmail(String email) {
        return authorRepository.findByEmail(email);
    }

    @Override
    public List<Author> findAllBySurnameAndAge(String surname, int age) {
        return authorRepository.findAllBySurnameAndAge(surname,age);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void saveAuthor(Author author) {
    authorRepository.save(author);
    }

    @Override
    public void deleteById(int id) {
    authorRepository.deleteById(id);
    }
}
