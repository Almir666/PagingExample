package org.spring.library.controller;

import org.spring.library.model.Author;
import org.spring.library.service.AuthorService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(Pageable pageable) {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{sureName}")
    public ResponseEntity<Author> getAuthorBySureName(@PathVariable String sureName) {
        return ResponseEntity.ok(authorService.getAuthorBySureName(sureName));
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return new ResponseEntity<>(authorService.createAuthor(author), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable long id) {
        return ResponseEntity.ok(authorService.deleteAuthor(id));
    }
}
