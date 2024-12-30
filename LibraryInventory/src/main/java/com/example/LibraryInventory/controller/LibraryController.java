package com.example.LibraryInventory.controller;
import com.example.LibraryInventory.model.Book;
import com.example.LibraryInventory.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class LibraryController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> displayAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{key}")
    public List<Book> findBooks(@PathVariable String key){
        return bookService.findBooks(key);
    }

    @PutMapping("/update/{bookId}")
    public String updateBook(@PathVariable String bookId,@RequestBody Book book){
        return bookService.updateBooks(bookId,book);
    }

    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable String bookId){
        return bookService.deleteBook(bookId);
    }
}
