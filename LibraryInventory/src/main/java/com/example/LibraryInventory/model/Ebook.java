package com.example.LibraryInventory.model;


public class Ebook extends Book {

    public Ebook(Integer bookId, String title, String author, String genre, Integer pubYear) {
        super(bookId, title, author, genre, pubYear);
    }

    @Override
    public String toString() {
        return "Ebook{} " + super.toString();
    }
}