package org.spring.library.controller;

import org.spring.library.model.Book;
import org.spring.library.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public ResponseEntity<Page<Book>> getAllBooks(@RequestParam int page,
                                                  @RequestParam int size,
                                                  @RequestParam String sortBy) {

        return ResponseEntity.ok(bookService.getAllBooks(page, size, sortBy));
    }

    @GetMapping("/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title) {
        return ResponseEntity.ok(bookService.getBookByTitle(title));
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.createBook(book), HttpStatus.CREATED);
    }

    @PutMapping("/{title}")
    public ResponseEntity<Book> updateBook(@PathVariable String title, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(title, book));
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<Book> deleteBook(@PathVariable String title) {
        return ResponseEntity.ok(bookService.deleteBook(title));
    }
}
