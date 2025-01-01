package com.example.LibraryInventory.error;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message) {
        super(message);
    }
}
