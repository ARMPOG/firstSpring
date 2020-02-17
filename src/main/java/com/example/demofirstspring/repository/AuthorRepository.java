package com.example.demofirstspring.repository;

import com.example.demofirstspring.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    List<Author> findAllBySurname (String surname);

    Author findByEmail(String email);

    List<Author> findAllBySurnameAndAge(String surname, int age);


   /* @Query(value = "insert into author()", nativeQuery = true)
    void saveAuthor (Author author);*/



    void deleteById (int id);
}
