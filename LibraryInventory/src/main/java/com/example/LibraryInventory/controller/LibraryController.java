package com.example.LibraryInventory.controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class LibraryController {

    @GetMapping("/")
    public String displayAllBooks(){
        return "all book";
    }

    @GetMapping("/book/{bookId}")
    public String sow(){
        return "book";
    }

    @PutMapping("/update/{bookId}")
    public String updateBook(){
        return "book update";
    }

    @PostMapping("/add")
    public String addBook(){
        return "book add";
    }

    @DeleteMapping("/delete/{bookId}")
    public String deleteBook(){
        return "book delete";
    }
}
