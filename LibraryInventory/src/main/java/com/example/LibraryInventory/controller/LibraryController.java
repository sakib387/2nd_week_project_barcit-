package com.example.LibraryInventory.controller;

import com.example.LibraryInventory.model.Book;
import com.example.LibraryInventory.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String keyword) {
        return libraryService.searchBooks(keyword);
    }

    @PutMapping
    public String updateBook(@RequestParam Integer bookId, @RequestBody Book book) {
        return libraryService.updateBookById(bookId, book);
    }

    @PostMapping
    public String addBook(@RequestBody Book book, @RequestParam String type) {
        return libraryService.addBook(book, type);
    }

    @DeleteMapping
    public String deleteBook(@RequestParam Integer bookId) {
        return libraryService.deleteBookById(bookId);
    }
}
