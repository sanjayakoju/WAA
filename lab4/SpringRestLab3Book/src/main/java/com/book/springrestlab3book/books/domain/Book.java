package com.book.springrestlab3book.books.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {

    @NotNull
    @Size(min = 1, max = 8)
    private String isbn;
    @NotNull
    private String title;
    @NotNull
    private double price;
    @NotNull
    @Size(min = 3, max = 120, message = "Author name should be between size 3 to 10")
    private String author;

    public Book() {
    }

    public Book(String isbn, String title, double price, String author) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
