package org.spring.library.service;

import org.spring.library.exception.AuthorNotFoundException;
import org.spring.library.model.Author;
import org.spring.library.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorBySureName(String sureName) {
        return authorRepository.findBySurname(sureName).orElseThrow(AuthorNotFoundException::new);
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author deleteAuthor(long id) {
        return authorRepository.deleteById(id).orElseThrow(AuthorNotFoundException::new);
    }

}
