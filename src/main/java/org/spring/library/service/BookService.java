package org.spring.library.service;

import org.spring.library.exception.BookNotFoundException;
import org.spring.library.model.Book;
import org.spring.library.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Page<Book> getAllBooks(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return bookRepository.findAll(pageable);
    }

    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title).orElseThrow(BookNotFoundException::new);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(String title, Book book) {
        Book oldBook = bookRepository.findByTitle(title).orElseThrow(BookNotFoundException::new);
        oldBook.setTitle(book.getTitle());
        oldBook.setDescription(book.getDescription());
        oldBook.setAuthor(book.getAuthor());

        return bookRepository.save(oldBook);
    }

    public Book deleteBook(String title) {
        return bookRepository.deleteByTitle(title).orElseThrow(BookNotFoundException::new);
    }
}
