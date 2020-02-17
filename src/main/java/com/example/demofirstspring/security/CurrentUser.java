package com.example.demofirstspring.security;

import com.example.demofirstspring.model.Author;
import com.example.demofirstspring.model.UserType;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser  extends org.springframework.security.core.userdetails.User{

    private Author author;

    public CurrentUser(Author author) {
        super(author.getEmail(), "password",
                AuthorityUtils.createAuthorityList(author.getUserType().name()));
        this.author = author;
    }

    public Author getAuthor() {
        return this.author;
    }
    public UserType getRole(){
        return author.getUserType();
    }
}
