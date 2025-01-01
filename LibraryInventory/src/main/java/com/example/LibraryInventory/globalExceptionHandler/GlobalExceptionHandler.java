package com.example.LibraryInventory.globalExceptionHandler;
import com.example.LibraryInventory.error.AlreadeyExistException;
import com.example.LibraryInventory.error.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadeyExistException.class)
    public ResponseEntity<Object> handleAlreadyExistException(AlreadeyExistException ex) {
        Map<String, Object> response = new HashMap<>();

        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);

    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException ex) {
        Map<String, Object> response = new HashMap<>();

        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
}
