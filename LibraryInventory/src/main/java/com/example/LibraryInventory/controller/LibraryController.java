package com.example.LibraryInventory.controller;
import com.example.LibraryInventory.model.Book;
import com.example.LibraryInventory.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/")
    public List<Book> showAllBooks(){
        return libraryService.showAllBooks();
    }

    @GetMapping("/book/{key}")
    public List<Book> finOnedBooks(@PathVariable String key){
        return libraryService.finOnedBooks(key);
    }

    @PutMapping("/update/{bookId}")
    public String updateBooksById(@PathVariable String bookId,@RequestBody Book book){
        return libraryService.updateBooksById(bookId,book);
    }

    @PostMapping("{type}/add")
    public String addBook(@RequestBody Book book,@PathVariable String type){
        return libraryService.addBook(book,type);
    }

    @DeleteMapping("/delete/{bookId}")
    public String deleteBookById(@PathVariable String bookId){
        return libraryService.deleteBookById(bookId);
    }
}
