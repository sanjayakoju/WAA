package com.example.lab7graphql.book.service;

import com.example.lab7graphql.book.model.Book;

import java.util.List;


public interface BookService {

    Book addBook(Book book);
    Book getBookByISBN(String isbn);
    Book deleteBookByIsbn(String isbn);
    Book updateBook(Book book);
    List<Book> getAllBook();
    List<Book> searchBook(String author);

    Book createBook(String isbn, String title, double price, String author);

    List<Book> getAllBook(int count);

    List<Book> getBookByCount(int count);
}
