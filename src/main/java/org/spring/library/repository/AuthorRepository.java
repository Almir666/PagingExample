package org.spring.library.repository;

import org.spring.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findBySurname(String sureName);

    Optional<Author> deleteById(long id);
}
