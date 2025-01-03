package com.example.LibraryInventory.model;


public class AudioBook extends Book {

    public AudioBook(Integer bookId, String title, String author, String genre, Integer pubYear) {
        super(bookId, title, author, genre, pubYear);
    }

    @Override
    public String toString() {
        return "AudioBook{} " + super.toString();
    }
}