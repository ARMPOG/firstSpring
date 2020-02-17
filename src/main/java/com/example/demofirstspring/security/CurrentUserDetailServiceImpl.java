package com.example.demofirstspring.security;

import com.example.demofirstspring.model.Author;
import com.example.demofirstspring.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Author author = authorRepository.findByEmail(email);
        if (author == null) {
            throw new UsernameNotFoundException(String.format("User with email $s not fount",email));
        }
        return new CurrentUser(author);
    }
}
