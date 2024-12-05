package org.spring.library.repository;

import org.spring.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
    Optional<Book> deleteByTitle(String title);

    boolean existsBookByTitle(String title);
}
