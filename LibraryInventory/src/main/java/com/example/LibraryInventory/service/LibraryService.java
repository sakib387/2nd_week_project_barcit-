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

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookFactory bookFactory;

    public List<Book> showAllBooks() {

        return  bookRepository.getAllBooks();

    }

    public List<Book> finOnedBooks(String key) {

        return bookRepository.searchBooks(key);

    }

    public String updateBooksById(String bookId, Book book) {

        boolean update= bookRepository.updateBooks(bookId,book);
        System.out.println(update);
        if (update) {
            return "Book updated successfully!!";
        } else {
            throw new BookNotFoundException("Book not found with ID: " + bookId);
        }


    }


    public String deleteBookById(String bookId) {

        return bookRepository.deleteBook(bookId);

    }

    public String addBook(Book book,String type) {

        Book createdBook = bookFactory.createBook(type, book.getBookId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getPubYear());

        if(! bookRepository.addBook(book)){
            return "Book added successfully ):";
        }
        else{
            throw new AlreadeyExistException("Book already exist with this id "+book.getBookId());
        }

    }
}
