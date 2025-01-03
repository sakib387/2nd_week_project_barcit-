package com.example.LibraryInventory.service;
import com.example.LibraryInventory.error.AlreadeyExistException;
import com.example.LibraryInventory.error.BookNotFoundException;
import com.example.LibraryInventory.model.Book;
import com.example.LibraryInventory.model.BookFactory;
import com.example.LibraryInventory.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class LibraryService {

    private final BookRepository bookRepository;
    private final BookFactory bookFactory;


    public LibraryService(BookRepository bookRepository, BookFactory bookFactory) {
        this.bookRepository = bookRepository;
        this.bookFactory = bookFactory;
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public List<Book> searchBooks(String keyword) {
        return bookRepository.searchBooks(keyword);
    }

    public String updateBookById(Integer bookId, Book book) {
        if (bookRepository.updateBook(bookId, book)) {
            return "Book updated successfully.";
        } else {
            throw new BookNotFoundException("Book not found with ID: " + bookId);
        }
    }

    public String deleteBookById(Integer bookId) {
        if (bookRepository.deleteBook(bookId)) {
            return "Book deleted successfully.";
        } else {
            throw new BookNotFoundException("Book not found with ID: " + bookId);
        }
    }

    public String addBook(Book book, String type) {
        Book newBook = bookFactory.createBook(type, book.getBookId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getPubYear());
        if (!bookRepository.addBook(newBook)) {
            return "Book added successfully.";
        } else {
            throw new AlreadeyExistException("Book already exists with ID: " + book.getBookId());
        }
    }
}
