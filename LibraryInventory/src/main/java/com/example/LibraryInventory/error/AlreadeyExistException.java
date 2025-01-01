package com.example.LibraryInventory.error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

 public class AlreadeyExistException extends RuntimeException{

    public AlreadeyExistException(String message) {
        super(message);
    }

}
