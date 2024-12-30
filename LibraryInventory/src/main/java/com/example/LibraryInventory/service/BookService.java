package com.example.LibraryInventory.service;

import com.example.LibraryInventory.model.Book;
import com.example.LibraryInventory.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private List<Book> books=new ArrayList<>();


    public List<Book> getAllBooks() {
        Book book=new Book();
        book.setBookId("1");
        book.setAuthor("sakib");
        book.setGenre("notmal");
        book.setTitle("Azaira");
        book.setPubYear(2002);

        return  books;
    }

    public List<Book> findBooks(String key) {

        List<Book>b=  books.stream().filter(book->book.getBookId().equals(key)||
                                            book.getAuthor().equals(key)||book.getTitle().equals(key)
                                            ||book.getPubYear().toString().equals(key)||book.getGenre().equals(key)).collect(Collectors.toList());
        System.out.println("ksdjflkjas");
        System.out.println(key);
        return b;
    }

    public String updateBooks(String bookId,Book book) {
        List<Book>bks=  books.stream().filter(bk->bk.getBookId().equals(bookId) ).collect(Collectors.toList());
        for(Book bk:bks){
            if(!bk.getAuthor().equals(book.getAuthor()))bk.setAuthor(book.getAuthor());
            if(!bk.getGenre().equals(book.getGenre()))bk.setGenre(book.getGenre());
            if(!bk.getTitle().equals(book.getTitle()))bk.setTitle(book.getTitle());
            if(!bk.getPubYear().equals(book.getPubYear()))bk.setPubYear(book.getPubYear());

        }
        return "Book updated successfully :)";
    }

    public String addBook(Book book) {
        books.add(book);
        return "book added successfully !!";
    }

    public String deleteBook(String bookId) {

        Book book=books.stream().filter(b->b.getBookId().equals(bookId)).findFirst().orElse(null);
        System.out.println(book);
        if(book==null)
             return "Book not exist with this Id (: ";
         else {
             books.remove(book);
             return "Book deleted successfully !!";
        }
    }
}
