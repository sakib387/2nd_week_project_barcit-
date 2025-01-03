package com.example.LibraryInventory.model;

import org.springframework.stereotype.Component;


@Component
public class BookFactory {

    public Book createBook(String type, Integer bookId, String title, String author, String genre, Integer pubYear) {
        if ("ebook".equalsIgnoreCase(type)) {
            return new Ebook(bookId, title, author, genre, pubYear);
        } else if ("audiobook".equalsIgnoreCase(type)) {
            return new AudioBook(bookId, title, author, genre, pubYear);
        } else {
            return new Book(bookId, title, author, genre, pubYear);
        }
    }
}