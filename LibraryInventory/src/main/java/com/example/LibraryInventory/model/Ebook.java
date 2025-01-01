package com.example.LibraryInventory.model;

import org.springframework.stereotype.Component;

@Component
public class Ebook extends Book{
    public Ebook() {
    }

    public Ebook(String bookId, String title, String author, String genre, Integer pubYear) {
        super(bookId, title, author, genre, pubYear);
    }

    @Override
    public String toString() {
        return "Ebook{} " + super.toString();
    }
}