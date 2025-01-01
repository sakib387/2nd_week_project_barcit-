package com.example.LibraryInventory.error;

public class AlreadeyExistException extends RuntimeException{
    public AlreadeyExistException(String message) {
        super(message);
    }
}
