package com.example.LibraryInventory.model;

import org.springframework.stereotype.Component;

@Component
public class AudioBook extends Book{
    public AudioBook() {
    }

    public AudioBook(String bookId, String title, String author, String genre, Integer pubYear) {
        super(bookId, title, author, genre, pubYear);
    }

    @Override
    public String toString() {
        return "AudioBook{} " + super.toString();
    }
}
