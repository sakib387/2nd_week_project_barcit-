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


    /// Author , Titile , Genre can be Upercase or lowercase in that situation mismatch could occur.
    /// Fixed: Used equalsIgnoreCase()
    /// Unfixed: Id should be an int Not a string.
    public List<Book> searchBooks(String key) {

        List<Book>filtedBook=  books.stream().filter(book->book.getBookId().equals(key)||
                book.getAuthor().equalsIgnoreCase(key)||book.getTitle().equalsIgnoreCase(key)
                ||book.getPubYear().toString().equals(key)||book.getGenre().equalsIgnoreCase(key)).collect(Collectors.toList());

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

    /// getBookId() does not have any NullPointerException,
    /// BookId is String which might lead to improper formatting like trailling zeros or case-mismatch
    /// Problem:- The method returns True if the book already exists (`count > 0`)
    /// and False otherwise. However, logically, when a new book is added (`count == 0`),
    /// the return value should indicate success (e.g., return `true` for success).
    public boolean addBook(Book newBook) {

        int count=(int) books.stream().filter(book->book.getBookId().equals(newBook.getBookId())).count();
        if(count==0)
            books.add(newBook);

        ///  fixed here
        return count==0;

    }


    /// Problem:- `bookId` is a `String`,
    /// which can lead to issues such as:
    /// Trailing or leading whitespace.
    /// Case sensitivity issues (if `bookId` strings have different casing).
    /// Formatting inconsistencies (e.g., the same `bookId` represented differently, such as "001" vs "1").
    /// Partial Fix: Used ignorecase equals
    public boolean deleteBook(String bookId) {

       Book bookToDelete =books.stream().filter(book->book.getBookId().equalsIgnoreCase(bookId)).findFirst().orElse(null);

       if(bookToDelete ==null){
           return false;
       }
       else {
         books.remove(bookToDelete );
         return true;
       }

    }

}
