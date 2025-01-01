package com.example.LibraryInventory.repository;
import com.example.LibraryInventory.model.Book;
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

        List<Book>filtedBook=  books.stream().filter(book->book.getBookId().equals(key)||
                book.getAuthor().equals(key)||book.getTitle().equals(key)
                ||book.getPubYear().toString().equals(key)||book.getGenre().equals(key)).collect(Collectors.toList());

        return filtedBook;

    }

    public boolean updateBooks(String bookId,Book updatedBook) {

        List<Book>filteredBooks =  books.stream().filter(book->book.getBookId().equals(bookId) ).collect(Collectors.toList());
        for (Book existingBook : filteredBooks) {
            if (!existingBook.getAuthor().equals(updatedBook.getAuthor()) && updatedBook.getAuthor() != null) {
                existingBook.setAuthor(updatedBook.getAuthor());
            }
            if (!existingBook.getGenre().equals(updatedBook.getGenre()) && updatedBook.getGenre() != null) {
                existingBook.setGenre(updatedBook.getGenre());
            }
            if (!existingBook.getTitle().equals(updatedBook.getTitle()) && updatedBook.getTitle() != null) {
                existingBook.setTitle(updatedBook.getTitle());
            }
            if (!existingBook.getPubYear().equals(updatedBook.getPubYear()) && updatedBook.getPubYear() != null) {
                existingBook.setPubYear(updatedBook.getPubYear());
            }
        }
        return !filteredBooks .isEmpty();
    }

    public boolean addBook(Book newBook) {

        int count=(int) books.stream().filter(book->book.getBookId().equals(newBook.getBookId())).count();
        if(count==0)
            books.add(newBook);

        return count>0;

    }

    public boolean deleteBook(String bookId) {

       Book bookToDelete =books.stream().filter(book->book.getBookId().equals(bookId)).findFirst().orElse(null);

       if(bookToDelete ==null){
           return false;
       }
       else {
         books.remove(bookToDelete );
         return true;
       }

    }

}
