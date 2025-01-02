package com.example.LibraryInventory.repository;

import com.example.LibraryInventory.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Book> searchBooks(String keyword) {
        return books.stream()
                .filter(book -> book.getBookId().equalsIgnoreCase(keyword) ||
                        book.getAuthor().equalsIgnoreCase(keyword) ||
                        book.getTitle().equalsIgnoreCase(keyword) ||
                        book.getPubYear().toString().equals(keyword) ||
                        book.getGenre().equalsIgnoreCase(keyword))
                .collect(Collectors.toList());
    }

    public boolean updateBook(String bookId, Book updatedBook) {
        List<Book> matchedBooks = books.stream()
                .filter(book -> book.getBookId().equals(bookId))
                .collect(Collectors.toList());

        matchedBooks.forEach(existingBook -> {
            if (updatedBook.getAuthor() != null && !updatedBook.getAuthor().isEmpty()) {
                existingBook.setAuthor(updatedBook.getAuthor());
            }
            if (updatedBook.getGenre() != null && !updatedBook.getGenre().isEmpty()) {
                existingBook.setGenre(updatedBook.getGenre());
            }
            if (updatedBook.getTitle() != null && !updatedBook.getTitle().isEmpty()) {
                existingBook.setTitle(updatedBook.getTitle());
            }
            if (updatedBook.getPubYear() != null) {
                existingBook.setPubYear(updatedBook.getPubYear());
            }
        });

        return !matchedBooks.isEmpty();
    }

    public boolean addBook(Book newBook) {
        boolean bookExists = books.stream()
                .anyMatch(book -> book.getBookId().equals(newBook.getBookId()));

        if (!bookExists) {
            books.add(newBook);
        }

        return bookExists;
    }

    public boolean deleteBook(String bookId) {
        return books.removeIf(book -> book.getBookId().equals(bookId));
    }
}
