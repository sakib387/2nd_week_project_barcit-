package com.example.LibraryInventory.repository;

import com.example.LibraryInventory.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class BookRepository {

    private List<Book> books=new ArrayList<>();


    public List<Book> getAllBooks() {

        return  books;
    }

    public List<Book> searchBooks(String key) {

        List<Book>b=  books.stream().filter(book->book.getBookId().equals(key)||
                book.getAuthor().equals(key)||book.getTitle().equals(key)
                ||book.getPubYear().toString().equals(key)||book.getGenre().equals(key)).collect(Collectors.toList());

        return b;

    }

    public boolean updateBooks(String bookId,Book book) {

        List<Book>bks=  books.stream().filter(bk->bk.getBookId().equals(bookId) ).collect(Collectors.toList());
        for(Book bk:bks){
            if(!bk.getAuthor().equals(book.getAuthor())&&bk.getAuthor()!=null)bk.setAuthor(book.getAuthor());
            if(!bk.getGenre().equals(book.getGenre())&&bk.getGenre()!=null)bk.setGenre(book.getGenre());
            if(!bk.getTitle().equals(book.getTitle())&&bk.getTitle()!=null)bk.setTitle(book.getTitle());
            if(!bk.getPubYear().equals(book.getPubYear())&&bk.getPubYear()!=null)bk.setPubYear(book.getPubYear());

        }
        return !bks.isEmpty();
    }

    public boolean addBook(Book book) {

        Long count=books.stream().filter(b->b.getBookId().equals(book.getBookId())).count();
        if(count==0)
            books.add(book);

        return count>0;

    }

    public String deleteBook(String bookId) {

        Book book=books.stream().filter(b->b.getBookId().equals(bookId)).findFirst().orElse(null);
          if(book==null)
            return "Book not exist with this Id (: "+bookId;
        else {
            books.remove(book);
            return "Book deleted successfully !!";
        }

    }

}
