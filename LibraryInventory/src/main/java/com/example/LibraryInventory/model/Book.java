package com.example.LibraryInventory.model;
import org.springframework.stereotype.Component;



@Component
public class Book {


    private String bookId;
    private  String title;
    private String author;
    private String genre;
    private Integer pubYear;

    public Book() {
    }

    public Book(String bookId, String title, String author, String genre, Integer pubYear) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pubYear = pubYear;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPubYear() {
        return pubYear;
    }

    public void setPubYear(Integer pubYear) {
        this.pubYear = pubYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", pubYear=" + pubYear +
                '}';
    }
}
