package com.book.springrestlab3book.books.service;

import com.book.springrestlab3book.books.domain.Book;

import java.util.List;

public interface BookService {

    Book addBook(Book book);
    Book getBookByISBN(String isbn);
    Book deleteBookByIsbn(String isbn);
    Book updateBook(Book book);
    List<Book> getAllBook();
    List<Book> searchBook(String author);

}
