package com.example.LibraryInventory.repository;

import com.example.LibraryInventory.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;


@Repository
public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Book> searchBooks(String keyword) {
        return books.stream()
                .filter(book -> book.getBookId().toString().equalsIgnoreCase(keyword) ||
                        book.getAuthor().equalsIgnoreCase(keyword) ||
                        book.getTitle().equalsIgnoreCase(keyword) ||
                        book.getPubYear().toString().equals(keyword) ||
                        book.getGenre().equalsIgnoreCase(keyword))
                .collect(Collectors.toList());
    }

    public boolean updateBook(Integer bookId, Book updatedBook) {
        AtomicBoolean isUpdated = new AtomicBoolean(false);

        books.stream()
                .filter(book -> book.getBookId().equals(bookId))
                .forEach(existingBook -> {
                    if (updatedBook.getAuthor() != null && !updatedBook.getAuthor().isEmpty()) {
                        existingBook.setAuthor(updatedBook.getAuthor());
                        isUpdated.set(true);
                    }
                    if (updatedBook.getGenre() != null && !updatedBook.getGenre().isEmpty()) {
                        existingBook.setGenre(updatedBook.getGenre());
                        isUpdated.set(true);
                    }
                    if (updatedBook.getTitle() != null && !updatedBook.getTitle().isEmpty()) {
                        existingBook.setTitle(updatedBook.getTitle());
                        isUpdated.set(true);
                    }
                    if (updatedBook.getPubYear() != null) {
                        existingBook.setPubYear(updatedBook.getPubYear());
                        isUpdated.set(true);
                    }
                });

        return isUpdated.get();
    }


    public boolean addBook(Book newBook) {
        boolean bookExists = books.stream()
                .anyMatch(book -> book.getBookId().equals(newBook.getBookId()));

        if (!bookExists) {
            books.add(newBook);
        }

        return bookExists;
    }

    public boolean deleteBook(Integer bookId) {
        return books.removeIf(book -> book.getBookId().equals(bookId));
    }
}
